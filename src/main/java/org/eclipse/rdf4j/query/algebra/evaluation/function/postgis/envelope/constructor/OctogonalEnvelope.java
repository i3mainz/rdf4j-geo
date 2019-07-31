package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.OctagonalEnvelope;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class OctogonalEnvelope extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_octogonalEnvelope.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		return LiteralUtils.toGeometry(new OctagonalEnvelope(geom));

	}

}
