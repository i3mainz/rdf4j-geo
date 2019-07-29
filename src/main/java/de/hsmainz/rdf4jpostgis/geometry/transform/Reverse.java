package main.java.de.hsmainz.rdf4jpostgis.geometry.transform;

import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class Reverse extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {		
        Geometry reverseGeom = geom.reverse();
        return reverseGeom;
	}

}
