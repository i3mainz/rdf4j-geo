package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class MinimumClearance extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		org.locationtech.jts.precision.MinimumClearance clearance=new org.locationtech.jts.precision.MinimumClearance(geom);
        return clearance.getDistance();
	}

}
