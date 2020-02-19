package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

public class LineFromText extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
        WKTReader wktreader=new WKTReader();
        Geometry geom;
		try {
			geom = wktreader.read(input);
	        if("LINESTRING".equalsIgnoreCase(geom.getGeometryType().toUpperCase())){
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
		return POSTGIS.st_lineFromText.stringValue();
	}

}
