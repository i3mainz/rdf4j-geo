package main.java.de.hsmainz.rdf4jpostgis.linestring;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class EndPoint extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ENDPOINT.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		if (geom instanceof LineString) {

            Point point = ((LineString) geom).getEndPoint();
            return point;
        }else if(geom instanceof Point) {
        	return geom;
        }
		return null;
	}

}
