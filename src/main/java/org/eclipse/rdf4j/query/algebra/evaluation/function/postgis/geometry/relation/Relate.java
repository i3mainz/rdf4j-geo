package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationStringFunction;
import org.locationtech.jts.geom.Geometry;

public class Relate extends GeometricRelationStringFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_relate.stringValue();
	}

	@Override
	protected String relation(Geometry g1, Geometry g2) {
		return g1.relate(g2).toString();
	}

}
