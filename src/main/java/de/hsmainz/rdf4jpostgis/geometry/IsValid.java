package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;

public class IsValid extends GeometricAttributeFunction {

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
