package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import javax.media.jai.iterator.WritableRectIter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterIterator;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterUtils;
import org.locationtech.jts.geom.Coordinate;
import org.opengis.coverage.grid.GridCoordinates;

public class FlowDirection extends RasterModifierFunction {

	Double zFactor=null;
	
	@Override
	public String getURI() {
		return POSTGIS.ST_flowdirection.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage coverage) {
		return iter.calculateNewRaster(coverage);
	}
	
	RasterIterator iter=new RasterIterator() {

		@Override
		public void execute(WritableRectIter writer, GridCoordinates pos) {
			// https://pro.arcgis.com/en/pro-app/tool-reference/spatial-analyst/how-flow-direction-works.htm
	        // +-------+ +-----------+
	        // | 0 1 2 | | 32 64 128 |
	        // | 3 4 5 |>| 16 x 1 |
	        // | 6 7 8 | | 8 4 2 |
	        // +-------+ +-----------+

	        double[][] mx = RasterUtils.getSubMatrix(pos, 3, 3);
	        if (Double.isNaN(mx[1][1]) || RasterUtils.compareDouble(srcNoData, mx[1][1])) {
	            writer.setSample(0, NoData);
	            return;
	        }

	        Coordinate center_pos = new Coordinate(1, 1);
	        Coordinate max_drop_pos = null;

	        int flowDir = -1;
	        double max_drop = 0;
	        for (int row = 0; row < 3; row++) {
	            int dY = (int) (center_pos.y - row);
	            for (int col = 0; col < 3; col++) {
	                if (col == 1 && row == 1) {
	                    continue;
	                }

	                // The distance is calculated between cell centers.
	                // Therefore, if the cell size is 1, the distance between two orthogonal cells is 1,
	                // and the distance between two diagonal cells is 1.414 (the square root of 2)
	                int dX = (int) (center_pos.x - col);

	                // maximum_drop = change_in_z-value / distance * 100
	                double drop = (mx[1][1] - mx[col][row]) / (Math.hypot(dX, dY) * 100);
	                if (max_drop_pos == null || drop > max_drop) {
	                    max_drop_pos = new Coordinate(col, row);
	                    max_drop = drop;
	                }
	            }
	        }

	        flowDir = getFlowDirection(center_pos, max_drop_pos);

	        writer.setSample(0, flowDir);
	        //updateStatistics(flowDir);
			
		}
		
		private int getFlowDirection(Coordinate from, Coordinate to) {
	        // +-------+ +-----------+
	        // | 0 1 2 | | 32 64 128 |
	        // | 3 4 5 |>| 16 x 1 |
	        // | 6 7 8 | | 8 4 2 |
	        // +-------+ +-----------+

	        int directionPow = -1;
	        if (from.y == to.y) {
	            if (from.x < to.x) {
	                directionPow = 0; // 1
	            } else if (from.x == to.x) {
	                directionPow = -1; // c
	            } else {
	                directionPow = 4; // 16
	            }
	        } else if (from.y < to.y) {
	            if (from.x < to.x) {
	                directionPow = 1; // 2
	            } else if (from.x == to.x) {
	                directionPow = 2; // 4
	            } else {
	                directionPow = 3; // 8
	            }
	        } else {
	            if (from.x < to.x) {
	                directionPow = 7; // 128
	            } else if (from.x == to.x) {
	                directionPow = 6; // 64
	            } else {
	                directionPow = 5; // 32
	            }
	        }

	        if (directionPow <= -1) {
	            return 0;
	        }

	        return (int) Math.pow(2, directionPow);
	    }
		
	};

}
