package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsRing extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof LineString) {

            boolean isRing = ((LineString) geom).isRing();
            return isRing;
        }
		return false;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isRing.stringValue();
	}

}
