package main.java.de.hsmainz.rdf4jpostgis.geometry.exporter;

import java.math.BigInteger;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;

public class AsX3D extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
        StringBuilder builder=new StringBuilder();
        builder.append("<IndexedFaceSet coordIndex=\"");
        Integer index=0;
        for(Coordinate coord:geom.getCoordinates()) {
        	builder.append(index.toString());
        	index++;
        }
        builder.append("</IndexedFaceSet>");
        builder.append("<Coordinate point=\"");
        for(Coordinate coord:geom.getCoordinates()) {
        	builder.append(coord.getX()+" "+coord.getY()+" "+coord.getZ()+" ");
        }
        builder.append("\"/>");
        return header+builder.toString()+footer;
	}
	
	String header="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.2//EN\""+
			  "http://www.web3d.org/specifications/x3d-3.2.dtd\"><Scene><Shape>";
			String footer="</Shape></Scene></X3D>";
			@Override
			public String getURI() {
				// TODO Auto-generated method stub
				return POSTGIS.ASX3D.stringValue();
			}

}
