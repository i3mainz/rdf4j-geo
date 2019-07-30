package main.java.de.hsmainz.rdf4jpostgis.point;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class M extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		if(geom.getGeometryType().equalsIgnoreCase("Point")) {
			return geom.getCoordinate().getM();
		}
		return geom.getCentroid().getCoordinate().getM();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_m.stringValue();
	}

}
