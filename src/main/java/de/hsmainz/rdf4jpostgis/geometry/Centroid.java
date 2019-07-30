package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class Centroid extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_CENTROID.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
         Point centroid = geom.getCentroid();
         return centroid;
	}

}
