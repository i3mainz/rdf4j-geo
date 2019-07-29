package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsValid extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean attribute(Geometry geom) {
		return geom.isValid();
	}


}
