package main.java.de.hsmainz.rdf4jpostgis.envelope.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricConstructor;

public class MakeEnvelope extends GeometricConstructor {

	@Override
	public String getURI() {
		return POSTGIS.st_makeEnvelope.stringValue();
	}

	@Override
	public Geometry construct(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
