package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.simplify.VWSimplifier;

public class SimplifyVW extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_simplifyVW.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double tolerance) {
        //Simplify
        VWSimplifier simplifier = new VWSimplifier(geom);      
        simplifier.setDistanceTolerance(tolerance);

        Geometry simpleGeom = simplifier.getResultGeometry();
        return simpleGeom;
	}

}
