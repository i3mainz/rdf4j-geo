package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

/**
 * Returns the center point of the minimum bounding circle surrounding the geometry.
 */
public class MinimumBoundingCircleCenter extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_minimumBoundingCircleCenter.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		org.locationtech.jts.algorithm.MinimumBoundingCircle minCircle = new org.locationtech.jts.algorithm.MinimumBoundingCircle(geom);
        return minCircle.getCircle().getCentroid();
	}

}
