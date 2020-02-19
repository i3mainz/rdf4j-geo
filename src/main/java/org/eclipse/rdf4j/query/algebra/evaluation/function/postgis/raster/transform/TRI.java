package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import javax.media.jai.iterator.WritableRectIter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterIterator;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterUtils;
import org.opengis.coverage.grid.GridCoordinates;

public class TRI extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_tri.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage coverage) {
		return iter.calculateNewRaster(coverage);
	}
	
	RasterIterator iter=new RasterIterator() {
		
		@Override
		public void execute(WritableRectIter writer, GridCoordinates pos) {
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

	        // Terrain Ruggedness Index is average difference in height
	        final double tri = (Math.abs(mx[0][0] - mx[1][1]) + Math.abs(mx[1][0] - mx[1][1])
	                + Math.abs(mx[2][0] - mx[1][1]) + Math.abs(mx[0][1] - mx[1][1])
	                + Math.abs(mx[2][1] - mx[1][1]) + Math.abs(mx[0][2] - mx[1][1])
	                + Math.abs(mx[1][2] - mx[1][1]) + Math.abs(mx[2][2] - mx[1][1])) / 8.0;

	        writer.setSample(0, tri);
			
		}
	};

}
