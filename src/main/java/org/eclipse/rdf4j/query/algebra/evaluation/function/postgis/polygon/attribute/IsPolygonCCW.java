package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.algorithm.Orientation;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsPolygonCCW extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
            if (geom instanceof Polygon) {
                return Orientation.isCCW(geom.getCoordinates());
            }
            return false;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isPolygonCCW.stringValue();
	}

}
