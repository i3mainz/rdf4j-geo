package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class Area extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		return geom.getArea();
	}

}
