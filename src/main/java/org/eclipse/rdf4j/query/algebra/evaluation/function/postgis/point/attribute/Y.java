package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

/**
 * Returns the y coordinate of the given point geometry or the y coordinate of the centroid if the geometry given is not a point.
 */
public class Y extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		if(geom.getGeometryType().equalsIgnoreCase("Point")) {
			return geom.getCoordinate().y;
		}
		return geom.getCentroid().getY();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_y.stringValue();
	}

}
