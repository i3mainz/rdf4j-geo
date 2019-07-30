package org.eclipse.rdf4j.query.algebra.postgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class Perimeter extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_perimeter.stringValue();
	}

	@Override
	public double attribute(Geometry geom) {
		return geom.getLength();
	}

}
