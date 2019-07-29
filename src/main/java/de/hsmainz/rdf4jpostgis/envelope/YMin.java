package main.java.de.hsmainz.rdf4jpostgis.envelope;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.GeometricDoubleAttributeFunction;

public class YMin extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Double minY=0.;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(minY<coord.getY()) {
        		minY=coord.getY();
        	}
        }
        return minY;
	}

}
