package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import javax.media.jai.iterator.WritableRectIter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterIterator;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterUtils;
import org.opengis.coverage.grid.GridCoordinates;

public class Roughness extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_roughness.stringValue();
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
	        }else {
		        // Roughness is the largest difference between any two cells
		        double roughnessMin = mx[0][0];
		        double roughnessMax = mx[0][0];
		        for (int col = 0; col < 3; col++) {
		            for (int row = 0; row < 3; row++) {
		                roughnessMax = Math.max(roughnessMax, mx[col][row]);
		                roughnessMin = Math.min(roughnessMin, mx[col][row]);
		            }
		        }
		        double roughness = roughnessMax - roughnessMin;
		        writer.setSample(0, roughness);
	        }
		
		}
	};

}
