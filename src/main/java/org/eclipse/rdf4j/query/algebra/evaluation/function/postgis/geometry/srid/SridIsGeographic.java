package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Geometry;

public class SridIsGeographic extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.SRIDIsGeographic.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		return geom.getSRID()==4326;
	}

}
