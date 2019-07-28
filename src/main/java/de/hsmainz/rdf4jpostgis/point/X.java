package main.java.de.hsmainz.rdf4jpostgis.point;

import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.GeometricAttributeFunction;

public class X extends GeometricAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		if(geom.getGeometryType().equalsIgnoreCase("Point")) {
			return geom.getCoordinate().x;
		}
		return geom.getCentroid().getX();
	}

}
