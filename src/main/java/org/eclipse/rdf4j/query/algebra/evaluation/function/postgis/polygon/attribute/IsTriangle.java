package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

public class IsTriangle extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isTriangle.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof Polygon) {
	     	if(geom.getCoordinates().length==3) {
	     		return true;
	     	}
	    }
		return false;
	}
}
