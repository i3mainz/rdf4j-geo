package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;

public class Expand extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_expand.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double value) {
		Envelope env=geom.getEnvelopeInternal();
		env.expandBy(value);
		return LiteralUtils.toGeometry(env);
	}

}

