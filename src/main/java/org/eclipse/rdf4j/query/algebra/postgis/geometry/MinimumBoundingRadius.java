package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class MinimumBoundingRadius extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		org.locationtech.jts.algorithm.MinimumBoundingCircle minCircle = new org.locationtech.jts.algorithm.MinimumBoundingCircle(geom);
        return minCircle.getRadius();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_minimumBoundingRadius.stringValue();
	}

}
