package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;

public class IsRing extends GeometricAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof LineString) {

            boolean isRing = ((LineString) geom).isRing();
            return isRing;
        }
		return false;
	}

}
