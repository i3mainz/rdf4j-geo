package main.java.de.hsmainz.rdf4jpostgis.envelope;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class XMin extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Geometry geo=geom;
        Double minX=0.;
        for(Coordinate coord:geo.getCoordinates()) {
        	if(minX>coord.getX()) {
        		minX=coord.getX();
        	}
        }
        return minX;
	}

}
