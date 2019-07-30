package org.eclipse.rdf4j.query.algebra.postgis.envelope.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXFPIntersects extends GeometricRelationBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_bboxfpintersects.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom1, Geometry geom2) {
		Geometry transformed=LiteralUtils.transform(geom2, geom1);
		if(transformed.getPrecisionModel().isFloating()) {
			return geom1.getEnvelope().intersects(transformed.getEnvelope());
		}
		return false;
	}

}
