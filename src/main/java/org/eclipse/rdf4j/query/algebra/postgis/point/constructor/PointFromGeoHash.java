package main.java.de.hsmainz.rdf4jpostgis.point.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricConstructor;

public class PointFromGeoHash extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_pointFromGeoHash.stringValue();
	}

}
