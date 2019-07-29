package main.java.de.hsmainz.rdf4jpostgis.linestring;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class StartPoint extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {
		if (geom instanceof LineString) {
            Point point = ((LineString) geom).getStartPoint();
            return point;
        }else if(geom instanceof Point) {
        	return geom;
        }
		return null;

	}

}
