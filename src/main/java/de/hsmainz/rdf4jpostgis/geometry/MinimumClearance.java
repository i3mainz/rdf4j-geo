package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;

public class MinimumClearance extends GeometricAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		org.locationtech.jts.precision.MinimumClearance clearance=new org.locationtech.jts.precision.MinimumClearance(geom);
        return clearance.getDistance();
	}

}
