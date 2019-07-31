package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.geotoolkit.coverage.grid.GridCoordinates2D;
import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.coverage.grid.InvalidGridGeometryException;
import org.opengis.referencing.operation.TransformException;

public class UpperLeftY extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_upperLeftY.stringValue();
	}

	@Override
	public double attribute(GridCoverage2D raster) {
		try {
			return raster.getGridGeometry().getGridToCRS2D().transform(new GridCoordinates2D(0, 0),null).getY();
		} catch (InvalidGridGeometryException | TransformException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
