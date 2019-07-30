package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsValid extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isValid.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		return geom.isValid();
	}


}
