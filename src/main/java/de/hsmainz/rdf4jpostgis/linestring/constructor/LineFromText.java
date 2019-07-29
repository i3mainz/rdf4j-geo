package main.java.de.hsmainz.rdf4jpostgis.linestring.constructor;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricConstructor;

public class LineFromText extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
        WKTReader wktreader=new WKTReader();
        Geometry geom;
		try {
			geom = wktreader.read(input);
	        GeometryFactory fac=new GeometryFactory();
	        if("LINESTRING".equalsIgnoreCase(geom.getGeometryType().toUpperCase())){
	        	return LiteralUtils.createGeometry(geom.getCoordinates(), "LINESTRING", geom.getSRID());
	        }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     

        return null;
	}

}
