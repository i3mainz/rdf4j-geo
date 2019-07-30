package main.java.de.hsmainz.rdf4jpostgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class TransScale extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_transscale.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
