package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

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

	@Override
	public String getURI() {
		return POSTGIS.st_geomFromWKB.stringValue();
	}

}
