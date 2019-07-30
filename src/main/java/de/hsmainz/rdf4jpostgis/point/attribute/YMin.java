package main.java.de.hsmainz.rdf4jpostgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

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

	@Override
	public String getURI() {
		return POSTGIS.st_yMin.stringValue();
	}

}
