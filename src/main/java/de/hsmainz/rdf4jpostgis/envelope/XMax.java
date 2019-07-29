package main.java.de.hsmainz.rdf4jpostgis.envelope;

import org.apache.jena.sparql.expr.NodeValue;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.GeometricDoubleAttributeFunction;
import main.java.de.hsmainz.rdf4jpostgis.geometry.GeometricUnaryFunction;

public class XMax extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double attribute(Geometry geom) {
	        Double maxX=0.;
	        for(Coordinate coord:geom.getCoordinates()) {
	        	if(maxX<coord.getX()) {
	        		maxX=coord.getX();
	        	}
	        }
	        return maxX;
	}

}
