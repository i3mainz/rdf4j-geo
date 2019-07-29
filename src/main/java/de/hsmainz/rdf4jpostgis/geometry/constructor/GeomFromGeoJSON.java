package main.java.de.hsmainz.rdf4jpostgis.geometry.constructor;

import org.locationtech.jts.geom.Geometry;
import org.wololo.jts2geojson.GeoJSONReader;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricConstructor;

public class GeomFromGeoJSON extends GeometricConstructor {

	
	@Override
	public Geometry construct(String input) {
		GeoJSONReader reader = new GeoJSONReader();
		Geometry geom = reader.read(input);
        return geom;	 
	}
}
