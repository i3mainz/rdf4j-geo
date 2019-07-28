package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

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
