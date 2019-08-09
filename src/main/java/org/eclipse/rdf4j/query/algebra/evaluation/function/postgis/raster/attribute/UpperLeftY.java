package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.opengis.referencing.operation.TransformException;

public class UpperLeftY extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_upperLeftY.stringValue();
	}

	@Override
	public double attribute(GridCoverage raster) {
		try {
			return raster.getGridGeometry().getGridToCRS2D().transform(new GridCoordinates(0, 0),null).getY();
		} catch (InvalidGridGeometryException | TransformException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
