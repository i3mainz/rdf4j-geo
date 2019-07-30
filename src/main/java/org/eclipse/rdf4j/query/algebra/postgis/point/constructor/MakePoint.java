package org.eclipse.rdf4j.query.algebra.postgis.point.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricConstructor;

public class MakePoint extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
		
	}

	@Override
	public String getURI() {
		return POSTGIS.st_makePoint.stringValue();
	}

}
