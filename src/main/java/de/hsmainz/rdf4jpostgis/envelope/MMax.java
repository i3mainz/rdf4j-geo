package main.java.de.hsmainz.rdf4jpostgis.envelope;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class MMax extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Double maxM=0.;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(maxM<coord.getM()) {
        		maxM=coord.getM();
        	}
        }
        return maxM;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_mMax.stringValue();
	}

}
