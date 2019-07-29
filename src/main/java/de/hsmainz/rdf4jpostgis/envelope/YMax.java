package main.java.de.hsmainz.rdf4jpostgis.envelope;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class YMax extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Geometry geo=geom;
        Double maxY=0.;
        for(Coordinate coord:geo.getCoordinates()) {
        	if(maxY<coord.getY()) {
        		maxY=coord.getY();
        	}
        }
        return maxY;
	}

}
