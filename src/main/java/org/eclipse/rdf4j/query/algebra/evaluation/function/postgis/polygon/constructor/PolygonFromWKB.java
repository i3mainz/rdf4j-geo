package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

public class PolygonFromWKB extends GeometricConstructor{

	@Override
	public String getURI() {
		return POSTGIS.st_polygonFromWKB.stringValue();
	}

	@Override
	public Geometry construct(String input) {
		WKBReader wktreader=new WKBReader();
        Geometry geom;
		try {
			geom = wktreader.read(input.getBytes());
	        if("POLYGON".equalsIgnoreCase(geom.getGeometryType().toUpperCase())){
	        	return geom;
	        }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return null;
	}

}
