package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class ConvexHull extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_CONVEXHULL.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		org.locationtech.jts.algorithm.ConvexHull convex=new org.locationtech.jts.algorithm.ConvexHull(geom);

        Geometry convexHull = convex.getConvexHull();
        return convexHull;
	}

}
