package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

/**
 * Returns the minimum diameter of the given geometry.
 */
public class MinimumDiameter extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		org.locationtech.jts.algorithm.MinimumDiameter mindiam=new org.locationtech.jts.algorithm.MinimumDiameter(geom);
        return mindiam.getDiameter().getLength();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_minimumDiameter.stringValue();
	}
	

}
