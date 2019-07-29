package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class ConvexHull extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {
		org.locationtech.jts.algorithm.ConvexHull convex=new org.locationtech.jts.algorithm.ConvexHull(geom);

        Geometry convexHull = convex.getConvexHull();
        return convexHull;
	}

}
