package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class StartPoint extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_startPoint.stringValue();
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
