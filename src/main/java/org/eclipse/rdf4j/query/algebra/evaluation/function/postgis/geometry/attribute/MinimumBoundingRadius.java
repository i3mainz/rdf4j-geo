package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

/**
 * Returns the mininum bounding radius of the minimum bounding circle surrounding the geometry.
 */
public class MinimumBoundingRadius extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		org.locationtech.jts.algorithm.MinimumBoundingCircle minCircle = new org.locationtech.jts.algorithm.MinimumBoundingCircle(geom);
        return minCircle.getRadius();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_minimumBoundingRadius.stringValue();
	}

}
