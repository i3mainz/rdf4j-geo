package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Multi extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_multi.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		GeometryFactory fac=new GeometryFactory();
        if(geom.getGeometryType().toUpperCase().contains("MULTI")) {
        	return geom;
        }
        switch(geom.getGeometryType()) {
        case "Point": 
        	return LiteralUtils.createGeometry(geom.getCoordinates(), "MultiPoint", geom.getSRID());
        case "Polygon":
        	List<Polygon> polylist=new LinkedList<Polygon>();
        	polylist.add((Polygon)geometry.getXYGeometry());
        	return GeometryWrapperFactory.createMultiPolygon(polylist, geometry.getSrsURI(), WKTDatatype.URI).asNodeValue();	
        case "LineString":
        	List<LineString> linelist=new LinkedList<LineString>();
        	linelist.add((LineString)geometry.getXYGeometry());
        	return GeometryWrapperFactory.createMultiLineString(linelist, geometry.getSrsURI(), WKTDatatype.URI).asNodeValue();
        default:
        	throw new ExprEvalException("Geometry type does not have a Multi representation or is not supported", null);
        }
	}

}
