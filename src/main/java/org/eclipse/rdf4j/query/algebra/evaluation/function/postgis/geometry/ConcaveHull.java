package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;

public class ConcaveHull extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_CONCAVEHULL.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
