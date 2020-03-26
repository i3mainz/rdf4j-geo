package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryCRSAttributeFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.cs.CoordinateSystemAxis;

public class IsInCRSAreaOfValidity  extends GeometricBinaryCRSAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isInCRSAreaOfValidity.stringValue();
	}

	@Override
	public boolean operation(Geometry geom, CoordinateReferenceSystem crs) {
		CoordinateSystemAxis x = crs.getCoordinateSystem().getAxis(0);
	    CoordinateSystemAxis y = crs.getCoordinateSystem().getAxis(1);
	    boolean xUnbounded = Double.isInfinite(x.getMinimumValue()) && Double.isInfinite(x.getMaximumValue());
        boolean yUnbounded = Double.isInfinite(y.getMinimumValue()) && Double.isInfinite(y.getMaximumValue());
        if (xUnbounded && yUnbounded) {
            return false;
        }
        Coordinate[] c = geom.getCoordinates();
        for (int i = 0; i < c.length; i++) {
            if (!xUnbounded && ((c[i].x < x.getMinimumValue()) || (c[i].x > x.getMaximumValue()))) {
            	return false;
            }
            if (!yUnbounded && ((c[i].y < y.getMinimumValue()) || (c[i].y > y.getMaximumValue()))) {
                return false;
            }
        }
		return true;
	}

}
