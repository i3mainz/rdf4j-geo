package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class Length extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		return geom.getLength();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_Length.stringValue();
	}

}
