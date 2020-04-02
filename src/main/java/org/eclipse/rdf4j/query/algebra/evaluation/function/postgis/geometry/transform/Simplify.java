package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.simplify.DouglasPeuckerSimplifier;

public class Simplify extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_simplify.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double tolerance) {
        //Simplify
		 DouglasPeuckerSimplifier simplifier = new DouglasPeuckerSimplifier(geom);
         simplifier.setDistanceTolerance(tolerance);
         //simplifier.setEnsureValid(preserveCollapsed);

         Geometry simpleGeom = simplifier.getResultGeometry();

        return simpleGeom;
	}

}
