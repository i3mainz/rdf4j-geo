package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

/**
 * Returns the z coordinate of the given point geometry or the z coordinate of the centroid if the geometry given is not a point.
 */
public class Z extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		if(geom.getGeometryType().equalsIgnoreCase("Point")) {
			return geom.getCoordinate().z;
		}
		return geom.getCentroid().getCoordinate().z;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_z.stringValue();
	}

}
