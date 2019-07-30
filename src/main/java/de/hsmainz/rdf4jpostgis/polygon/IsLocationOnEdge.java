package main.java.de.hsmainz.rdf4jpostgis.polygon;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class IsLocationOnEdge extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isLocationOnEdge.stringValue();
	}

	@Override
	public double attribute(Geometry geom) {
		// TODO Auto-generated method stub
		return 0;
	}

}
