package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import javax.media.jai.iterator.WritableRectIter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterIterator;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterUtils;
import org.opengis.coverage.grid.GridCoordinates;

public class Hillshade extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_hillshade.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage coverage) {
		return iter.calculateNewRaster(coverage);
	}
	
	RasterIterator iter=new RasterIterator() {
		
		@Override
		public void execute(WritableRectIter writer, GridCoordinates pos) {
			// http://webhelp.esri.com/arcgisdesktop/9.2/index.cfm?TopicName=How%20Hillshade%20works
	        // Burrough, P. A. and McDonell, R.A., 1998. Principles of Geographical Information Systems
	        // (Oxford University Press, New York), p. 190.

	        // The hillshade raster has an integer value range of 0 to 255.

	        // +-------+ +-------+
	        // | 0 1 2 | | a b c |
	        // | 3 4 5 |>| d e f |
	        // | 6 7 8 | | g h i |
	        // +-------+ +-------+
	        double[][] mx = RasterUtils.getSubMatrix(pos, 3, 3, zFactor);
	        if (Double.isNaN(mx[1][1]) || RasterUtils.compareDouble(srcNoData, mx[1][1])) {
	            writer.setSample(0, NoData);
	            return;
	        }

	        double dZdX = ((mx[2][0] + 2 * mx[2][1] + mx[2][2]) - (mx[0][0] + 2 * mx[0][1] + mx[0][2]))
	                / (_8DX);
	        double dZdY = ((mx[0][2] + 2 * mx[1][2] + mx[2][2]) - (mx[0][0] + 2 * mx[1][0] + mx[2][0]))
	                / (_8DY);

	        if (Double.isNaN(dZdX) || Double.isNaN(dZdY) || Double.isInfinite(dZdX)
	                || Double.isInfinite(dZdY)) {
	            writer.setSample(0, NoData);
	            return;
	        }

	        // Computing the illumination angle
	        double zenith_deg = 90 - altitude;
	        double zenith_rad = zenith_deg * DEGTORAD;

	        // Computing the illumination direction
	        double azimuth_math = 360.0 - azimuth + 90;
	        if (azimuth_math >= 360) {
	            azimuth_math = azimuth_math - 360.0;
	        }
	        double azimuth_rad = azimuth_math * DEGTORAD;

	        // Computing Slope and Aspect
	        // Slope_rad = ATAN (z_factor * √ ([dz/dx]2 + [dz/dy]2))
	        double slope_rad = Math.atan(zFactor * Math.sqrt((dZdX * dZdX) + (dZdY * dZdY)));

	        double aspect_rad = 0.0;
	        if (dZdX == 0.0) {
	            if (dZdY > 0) {
	                aspect_rad = HALFPI;
	            } else if (dZdY < 0) {
	                aspect_rad = (2.0 * Math.PI) - HALFPI;
	            } else {
	                aspect_rad = Math.atan2(dZdY, -dZdX);
	                if (aspect_rad < 0) {
	                    aspect_rad = (2.0 * Math.PI) + aspect_rad;
	                }
	            }
	        } else {
	            aspect_rad = Math.atan2(dZdY, -dZdX);
	            if (aspect_rad < 0) {
	                aspect_rad = (2.0 * Math.PI) + aspect_rad;
	            }
	        }

	        // The hillshade algorithm
	        // 255.0 * ((cos(Zenith_rad) * cos(Slope_rad)) + (sin(Zenith_rad) * sin(Slope_rad) *
	        // cos(Azimuth_rad - Aspect_rad)))
	        double hsdVal = 255.0 * ((Math.cos(zenith_rad) * Math.cos(slope_rad)) + (Math
	                .sin(zenith_rad) * Math.sin(slope_rad) * Math.cos(azimuth_rad - aspect_rad)));

	        // Note that if the calculation of the hillshade value is < 0, the output cell value will be
	        // = 0.
	        if (hsdVal < 0) {
	            hsdVal = 0;
	        } else if (hsdVal > 255) {
	            hsdVal = 255;
	        }

	        writer.setSample(0, hsdVal);
			
		}
	};

}
