package main.java.de.hsmainz.rdf4jpostgis.linestring.constructor;

import java.math.BigInteger;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricConstructor;

public class MLineFromText extends GeometricConstructor {

	@Override
	public String getURI() {
		return POSTGIS.st_mLineFromText.stringValue();
	}
	
	@Override
	public Geometry construct(String input) {
        WKTReader wktreader=new WKTReader();
        Geometry geom;
		try {
			geom = wktreader.read(input);
	        if("MULTILINESTRING".equals(geom.getGeometryType().toUpperCase())){
	        	return geom;
	        }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
        return null;
	}
	
}
