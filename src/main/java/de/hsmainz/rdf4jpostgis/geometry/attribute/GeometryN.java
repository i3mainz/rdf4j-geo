package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierIntegerFunction;

public class GeometryN extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_geometryN.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
		return geom.getGeometryN(value);
	}

}
