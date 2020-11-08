package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import java.awt.geom.AffineTransform;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.coverage.grid.GridGeometry;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.opengis.referencing.datum.PixelInCell;

public class ShearY extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_sheary.stringValue();
	}

	@Override
	public Double attribute(GridCoverage raster) {
		GridGeometry gridGeometry2D = raster.getGridGeometry();
		AffineTransform gridToWorld = (AffineTransform) gridGeometry2D.getGridToCRS(PixelInCell.CELL_CENTER);
        return gridToWorld.getShearY();
	}

}
