package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

public class MakePoint extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
		return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_makePoint.stringValue();
	}

}
