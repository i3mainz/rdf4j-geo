package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class CompactnessRatio extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		if (geom instanceof Polygon) {
            final double circleRadius = Math.sqrt(geom.getArea() / Math.PI);
            final double circleCurcumference = 2 * Math.PI * circleRadius;
            return circleCurcumference / geom.getLength();
        }
		return Double.NaN;
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_COMPACTNESSRATIO.stringValue();
	}

}
