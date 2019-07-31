package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.algorithm.distance.DiscreteHausdorffDistance;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;

public class HausdorffDistance extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_hausdorffDistance.stringValue();
	}

	@Override
	protected double relation(Geometry g1, Geometry g2) {
        DiscreteHausdorffDistance distance = new DiscreteHausdorffDistance(g1, g2);
        return distance.distance();

	}

}
