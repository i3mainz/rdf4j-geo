package main.java.de.hsmainz.rdf4jpostgis.linestring.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricConstructor;

public class LineFromWKB extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
         WKBReader reader=new WKBReader();
         Geometry geom;
		try {
			geom = reader.read(input.getBytes());
	         if("LINESTRING".equals(geom.getGeometryType().toUpperCase())){
	        	 return LiteralUtils.createGeometry(geom.getCoordinates(), "LINESTRING", geom.getSRID());
	         }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_lineFromWKB.stringValue();
	}

}
