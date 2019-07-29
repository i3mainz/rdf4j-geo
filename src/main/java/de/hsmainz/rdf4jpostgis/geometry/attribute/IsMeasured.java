package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsMeasured extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		Boolean isMeasured=true;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(Double.isNaN(coord.getM())) {
        		isMeasured=false;
        	}
        }
        return isMeasured;
	}
	

}
