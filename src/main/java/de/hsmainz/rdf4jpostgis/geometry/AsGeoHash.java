package main.java.de.hsmainz.rdf4jpostgis.geometry;

import java.math.BigInteger;

import org.locationtech.jts.algorithm.Angle;
import org.locationtech.jts.geom.Geometry;


public class AsGeoHash extends GeometricStringExportFunction {

	GeoHashCoder coder=new GeoHashCoder();
	
	@Override
	public String operation(Geometry geom) {
		if(geom.getGeometryType().equalsIgnoreCase("Point")) {
			String geohash = coder.encode(Angle.toDegrees(geom.getCoordinate().getX()), Angle.toDegrees(geom.getCoordinate().getY()));
			return geohash;
		}
		throw new RuntimeException("Input geometry needs to be a Point");

	}

}
