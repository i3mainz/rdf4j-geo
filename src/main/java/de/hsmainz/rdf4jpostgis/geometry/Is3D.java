package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

public class Is3D extends GeometricAttributeFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean attribute(Geometry geom) {
		Boolean is3D=true;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(Double.isNaN(coord.getZ())) {
        		is3D=false;
        	}
        }
        return is3D;
	}


}
