package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

/**
 * Returns the minimum clearance line of this geometry.
 */
public class MinimumClearanceLine extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_minimumClearanceLine.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		org.locationtech.jts.precision.MinimumClearance clearance=new org.locationtech.jts.precision.MinimumClearance(geom);
        return clearance.getLine();
	}

}
