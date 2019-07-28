package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;

public class Length extends GeometricAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		return geom.getLength();
	}

}
