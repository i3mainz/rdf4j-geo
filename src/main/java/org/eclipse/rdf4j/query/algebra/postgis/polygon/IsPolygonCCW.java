package main.java.de.hsmainz.rdf4jpostgis.polygon;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.algorithm.Orientation;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsPolygonCCW extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
            if (geom instanceof Polygon) {
                return Orientation.isCCW(geom.getCoordinates());
            }
            return false;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isPolygonCCW.stringValue();
	}

}
