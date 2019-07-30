package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class PointOnSurface extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_pointOnSurface.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		return geom.getInteriorPoint();
	}

}
