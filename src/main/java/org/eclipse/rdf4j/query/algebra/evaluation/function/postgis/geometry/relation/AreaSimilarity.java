package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;
import org.locationtech.jts.algorithm.match.AreaSimilarityMeasure;
import org.locationtech.jts.geom.Geometry;

public class AreaSimilarity extends GeometricRelationDoubleFunction{

	@Override
	public String getURI() {
		return POSTGIS.ST_AREASIMILARITY.stringValue();
	}

	@Override
	protected double relation(Geometry g1, Geometry g2) {
		AreaSimilarityMeasure areasim=new AreaSimilarityMeasure();
	    return areasim.measure(g1, g2);
	}

	

}
