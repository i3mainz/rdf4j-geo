package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.densify.Densifier;
import org.locationtech.jts.geom.Geometry;

public class Densify extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_DENSIFY.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double tolerance) {
	   Geometry result=Densifier.densify(geom, tolerance);
	   return result;
	}

}
