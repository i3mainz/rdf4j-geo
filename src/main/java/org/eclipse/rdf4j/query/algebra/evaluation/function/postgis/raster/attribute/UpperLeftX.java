package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridGeometry;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.opengis.referencing.datum.PixelInCell;

public class UpperLeftX extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_upperLeftX.stringValue();
	}
	
	@Override
	public Double attribute(GridCoverage raster) {
		GridGeometry gridGeometry2D = raster.getGridGeometry();
		AffineTransform gridToWorld = (AffineTransform) gridGeometry2D.getGridToCRS(PixelInCell.CELL_CENTER);
		return gridToWorld.transform((Point2D) raster.getGridGeometry().getExtent().getHigh(), null).getX();
	}

}
