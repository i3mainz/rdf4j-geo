package main.java.de.hsmainz.rdf4jpostgis.envelope;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class ZMax extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Geometry geo=geom;
        Double maxZ=0.;
        for(Coordinate coord:geo.getCoordinates()) {
        	if(maxZ<coord.getZ()) {
        		maxZ=coord.getZ();
        	}
        }
        return maxZ;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_zMax.stringValue();
	}

}
