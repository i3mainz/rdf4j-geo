package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXBelow extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_bboxbelow.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom, Geometry geom2) {
		Geometry transformed=LiteralUtils.transform(geom2, geom);
		if(geom.getEnvelopeInternal().getMaxY()<transformed.getEnvelopeInternal().getMinY()) {
			return true;
		}
		return false;
	}

}
