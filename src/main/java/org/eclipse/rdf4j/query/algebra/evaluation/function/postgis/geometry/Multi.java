package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Multi extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_multi.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
        if(geom.getGeometryType().toUpperCase().contains("MULTI")) {
        	return geom;
        }
        switch(geom.getGeometryType()) {
        case "Point": 
        	return LiteralUtils.createGeometry(geom.getCoordinates(), "MultiPoint", geom.getSRID());
        case "Polygon":
        	List<Polygon> polylist=new LinkedList<Polygon>();
        	polylist.add((Polygon)geom);
        	return LiteralUtils.createGeometry(geom.getCoordinates(), "MultiPolygon", geom.getSRID());	
        case "LineString":
        	List<LineString> linelist=new LinkedList<LineString>();
        	linelist.add((LineString)geom);
        	return LiteralUtils.createGeometry(geom.getCoordinates(), "MultiLineString", geom.getSRID());	
        default:
        	return null;
        }
	}

}
