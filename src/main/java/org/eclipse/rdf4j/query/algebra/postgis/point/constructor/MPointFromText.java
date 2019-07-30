package org.eclipse.rdf4j.query.algebra.postgis.point.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricConstructor;

public class MPointFromText extends GeometricConstructor {

	@Override
	public String getURI() {
		return POSTGIS.st_mPointFromText.stringValue();
	}

	@Override
	public Geometry construct(String input) {
        WKTReader wktreader=new WKTReader();
        Geometry geom;
		try {
			geom = wktreader.read(input);
	        if("MULTIPOINT".equals(geom.getGeometryType().toUpperCase())){
	        	return geom;
	        }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

        return null;
	}
}
