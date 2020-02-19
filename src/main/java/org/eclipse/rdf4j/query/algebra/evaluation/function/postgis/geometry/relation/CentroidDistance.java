package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;

public class CentroidDistance extends GeometricRelationDoubleFunction{

	@Override
	public String getURI() {
		return POSTGIS.ST_CENTROIDDISTANCE.stringValue();
	}

	@Override
	protected double relation(Geometry g1, Geometry g2) {
		return g1.getCentroid().distance(g2.getCentroid());
	}

}
