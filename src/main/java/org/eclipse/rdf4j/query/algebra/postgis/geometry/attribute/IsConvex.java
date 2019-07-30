package org.eclipse.rdf4j.query.algebra.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsConvex extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof LinearRing || geom instanceof Polygon) {
            boolean isConvex = isConvex((Polygon)geom);
            return isConvex;
        }
        return false;
	}
	
	//https://gis.stackexchange.com/questions/157567/testing-if-geometry-is-convex-using-jts
	public static boolean isConvex(Polygon p) {
        LinearRing r = (LinearRing) p.getExteriorRing();
        int sign = 0;
        for(int i = 1; i < r.getNumPoints(); ++i) {
            Coordinate c0 = r.getCoordinateN(i == 0 ? r.getNumPoints() - 1 : i - 1);
            Coordinate c1 = r.getCoordinateN(i);
            Coordinate c2 = r.getCoordinateN(i == r.getNumPoints() - 1 ? 0 : i + 1);
            double dx1 = c1.x - c0.x;
            double dy1 = c1.y - c0.y;
            double dx2 = c2.x - c1.x;
            double dy2 = c2.y - c2.y;
            double z = dx1 * dy2 - dy1 * dx2;
            int s = z >= 0.0 ? 1 : -1;
            if(sign == 0) {
                sign = s; 
            } else if(sign != s) {
                return false;
            }
        }
        return true;
    }

	@Override
	public String getURI() {
		return POSTGIS.st_isConvex.stringValue();
	}

}
