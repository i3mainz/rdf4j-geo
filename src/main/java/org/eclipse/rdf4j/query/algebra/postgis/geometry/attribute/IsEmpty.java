package org.eclipse.rdf4j.query.algebra.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsEmpty extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isEmpty.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		return geom.isEmpty();
	}

}
