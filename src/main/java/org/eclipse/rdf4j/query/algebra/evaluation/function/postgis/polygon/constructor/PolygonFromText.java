package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

public class PolygonFromText extends GeometricConstructor {

	@Override
	public String getURI() {
		return POSTGIS.st_polygonFromText.stringValue();
	}

	@Override
	public Geometry construct(String input) {
		WKTReader wktreader=new WKTReader();
        Geometry geom;
		try {
			geom = wktreader.read(input);
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
