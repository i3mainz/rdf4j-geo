package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.simplify.TopologyPreservingSimplifier;

public class SimplifyPreserveTopology extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_simplifyPreserveTopology.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		TopologyPreservingSimplifier simplifier = new TopologyPreservingSimplifier(geom);
        Geometry simpleGeom = simplifier.getResultGeometry();
        return simpleGeom;
	}


}
