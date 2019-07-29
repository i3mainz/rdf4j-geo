package main.java.de.hsmainz.rdf4jpostgis.geometry.constructor;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricConstructor;

public class GeomFromWKB extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
        WKBReader reader=new WKBReader();
        Geometry geom=null;
		try {
			geom = reader.read(input.getBytes());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return geom;          
	}

}
