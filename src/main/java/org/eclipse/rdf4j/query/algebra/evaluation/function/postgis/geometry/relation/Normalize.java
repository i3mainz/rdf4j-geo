package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;

public class Normalize extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_normalize.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		return geom.norm();
	}

}
