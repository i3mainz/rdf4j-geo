package org.eclipse.rdf4j.query.algebra.postgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricUnaryFunction;

public class Centroid extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_CENTROID.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
         Point centroid = geom.getCentroid();
         return centroid;
	}

}
