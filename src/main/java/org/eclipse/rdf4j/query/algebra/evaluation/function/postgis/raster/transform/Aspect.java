package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import javax.media.jai.iterator.WritableRectIter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterIterator;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterUtils;
import org.opengis.coverage.grid.GridCoordinates;

/**
 * Calculates the aspect of a GridCoverage.
 *
 */
public class Aspect extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_aspect.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage coverage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	RasterIterator iter=new RasterIterator() {
		
		@Override
		public void execute(WritableRectIter writer, GridCoordinates pos) {
			// http://webhelp.esri.com/arcgisdesktop/9.3/index.cfm?TopicName=How%20Aspect%20works
	        // Burrough, P. A. and McDonell, R.A., 1998. Principles of Geographical Information Systems
	        // (Oxford University Press, New York), p. 190.
	        // [dz/dx] = ((c + 2f + i) - (a + 2d + g)) / 8
	        // [dz/dy] = ((g + 2h + i) - (a + 2b + c)) / 8
	        // aspect = 57.29578 * atan2([dz/dy], -[dz/dx])

	        // Aspect is expressed in positive degrees from 0 to 359.9, measured clockwise from north.
	        // Cells in the input raster that are flat—with zero slope—are assigned an aspect of -1.
	        // If the center cell in the immediate neighborhood (3 x 3 window) is NoData,
	        // the output is NoData.
	        // If any neighborhood cells are NoData, they are first assigned the value of the center
	        // cell, then the aspect is computed.

	        // +-------+ +-------+
	        // | 0 1 2 | | a b c |
	        // | 3 4 5 |>| d e f |
	        // | 6 7 8 | | g h i |
	        // +-------+ +-------+
	        double[][] mx = RasterUtils.getSubMatrix(pos, 3, 3);
	        if (Double.isNaN(mx[1][1]) || RasterUtils.compareDouble(srcNoData, mx[1][1])) {
	            writer.setSample(0, NoData);
	            return;
	        }

	        double dZdX = ((mx[2][0] + 2 * mx[2][1] + mx[2][2]) - (mx[0][0] + 2 * mx[0][1] + mx[0][2]))
	                / (_8DX);
	        double dZdY = ((mx[0][2] + 2 * mx[1][2] + mx[2][2]) - (mx[0][0] + 2 * mx[1][0] + mx[2][0]))
	                / (_8DY);

	        double rise_run = (dZdX * dZdX) + (dZdY * dZdY);
	        double slope = Math.toDegrees(Math.atan(Math.sqrt(rise_run)));
	        if (Double.isNaN(slope) || Double.isInfinite(slope) || slope == 0) {
	            writer.setSample(0, -1);
	            //updateStatistics(-1);
	            return;
	        }

	        // aspect
	        dZdX = ((mx[2][0] + 2 * mx[2][1] + mx[2][2]) - (mx[0][0] + 2 * mx[0][1] + mx[0][2])) / (8.0);
	        dZdY = ((mx[0][2] + 2 * mx[1][2] + mx[2][2]) - (mx[0][0] + 2 * mx[1][0] + mx[2][0])) / (8.0);

	        // double aspect = Math.toDegrees(Math.atan2(H, -G));
	        double aspect = Math.atan2(dZdY, -dZdX) * RADTODEG;

	        if (aspect < 0) {
	            aspect = 90.0 - aspect;
	        } else if (aspect > 90.0) {
	            aspect = 360.0 - aspect + 90.0;
	        } else {
	            aspect = 90.0 - aspect;
	        }

	        if (aspect < 0 || aspect > 360) {
	            aspect = -1.0;
	        }

	        writer.setSample(0, aspect);
			
		}
	};

}
