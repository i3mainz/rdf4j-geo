package main.java.de.hsmainz.rdf4jpostgis.envelope;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class ZMin extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Geometry geo=geom;
        Double minZ=0.;
        for(Coordinate coord:geo.getCoordinates()) {
        	if(minZ>coord.getZ()) {
        		minZ=coord.getZ();
        	}
        }
        return minZ;
	}

}
