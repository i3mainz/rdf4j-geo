package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

public class MakeEnvelope extends GeometricConstructor {

	@Override
	public String getURI() {
		return POSTGIS.st_makeEnvelope.stringValue();
	}

	@Override
	public Geometry construct(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
