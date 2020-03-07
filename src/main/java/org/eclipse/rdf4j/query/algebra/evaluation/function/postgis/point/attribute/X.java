package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

/**
 * Returns the x coordinate of the given point geometry or the x coordinate of the centroid if the geometry given is not a point.
 */
public class X extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		if(geom.getGeometryType().equalsIgnoreCase("Point")) {
			return geom.getCoordinate().x;
		}
		return geom.getCentroid().getX();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_x.stringValue();
	}

}
