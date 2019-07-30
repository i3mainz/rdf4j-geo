package main.java.de.hsmainz.rdf4jpostgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
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

	@Override
	public String getURI() {
		return POSTGIS.st_zMin.stringValue();
	}

}