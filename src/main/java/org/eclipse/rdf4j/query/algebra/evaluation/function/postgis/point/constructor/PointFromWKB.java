package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

/**
 * Creates a point from a WKB string representation.
 */
public class PointFromWKB extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
		WKBReader wktreader=new WKBReader();
        Geometry geom;
		try {
			geom = wktreader.read(input.getBytes());
	        if("POINT".equalsIgnoreCase(geom.getGeometryType().toUpperCase())){
	        	return geom;
	        }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_pointFromWKB.stringValue();
	}

}
