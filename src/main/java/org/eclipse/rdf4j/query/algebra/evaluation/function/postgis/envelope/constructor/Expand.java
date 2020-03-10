package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Geometry;

public class Expand extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_expand.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double factor) {
		/*geom.getEnvelopeInternal().
		Geometry transformed=LiteralUtils.transform(geom2, geom);
		if(geom.getEnvelope().overlaps(transformed.getEnvelope())) {
			return true;
		}
		if(geom.getEnvelopeInternal().getMaxY()>transformed.getEnvelopeInternal().getMinY()) {
			return true;
		}
		return false;*/
		return null;
	}




}
