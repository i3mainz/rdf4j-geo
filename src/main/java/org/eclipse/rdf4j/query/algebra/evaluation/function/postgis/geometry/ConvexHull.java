package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class ConvexHull extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_CONVEXHULL.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		org.locationtech.jts.algorithm.ConvexHull convex=new org.locationtech.jts.algorithm.ConvexHull(geom);
        Geometry convexHull = convex.getConvexHull();
        return convexHull;
	}

}
