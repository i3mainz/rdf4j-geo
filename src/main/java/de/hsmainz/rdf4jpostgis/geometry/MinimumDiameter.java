package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;

public class MinimumDiameter extends GeometricAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		org.locationtech.jts.algorithm.MinimumDiameter mindiam=new org.locationtech.jts.algorithm.MinimumDiameter(geom);
        return mindiam.getDiameter().getLength();
	}
	

}
