package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsEmpty extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isEmpty.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		return geom.isEmpty();
	}

}
