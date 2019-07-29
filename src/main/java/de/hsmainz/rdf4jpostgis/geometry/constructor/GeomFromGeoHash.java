package main.java.de.hsmainz.rdf4jpostgis.geometry.constructor;

import java.text.ParseException;

import org.apache.jena.sparql.expr.ExprEvalException;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.opengis.geometry.DirectPosition;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricConstructor;

public class GeomFromGeoHash extends GeometricConstructor{

	@Override
	public Geometry construct(String input) {
		Double precision=v2.getDouble();
		DirectPosition pos=coder.decode(input);
		Coordinate coord=new Coordinate(pos.getCoordinate()[1], pos.getCoordinate()[0]);
		return GeometryWrapperFactory.createPoint(coord,WKTDatatype.URI).asNodeValue();
		
	}

}
