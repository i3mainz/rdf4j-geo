package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class Perimeter extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_perimeter.stringValue();
	}

	@Override
	public double attribute(Geometry geom) {
		return geom.getLength();
	}

}
