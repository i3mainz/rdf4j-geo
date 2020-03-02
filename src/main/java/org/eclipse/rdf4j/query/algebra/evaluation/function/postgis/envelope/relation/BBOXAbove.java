package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

/**
 * Returns true if the bounding box of geometry 1 is above the boundingbox of geometry 2.
 */
public class BBOXAbove extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_bboxabove.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom, Geometry geom2) {
		Geometry transformed=LiteralUtils.transform(geom2, geom);
		if(geom.getEnvelope().overlaps(transformed.getEnvelope())) {
			return true;
		}
		if(geom.getEnvelopeInternal().getMaxY()>transformed.getEnvelopeInternal().getMinY()) {
			return true;
		}
		return false;
	}

}
