package org.eclipse.rdf4j.query.algebra.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricIntegerAttributeFunction;

public class NumGeometries extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_numGeometries.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
		return geom.getNumGeometries();
	}

}
