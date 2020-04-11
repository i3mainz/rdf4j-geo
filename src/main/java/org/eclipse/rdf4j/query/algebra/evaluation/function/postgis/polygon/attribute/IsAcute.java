package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.Triangle;

public class IsAcute extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isAcute.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof Polygon) {
        	if(geom.getCoordinates().length==3) {
        		Coordinate p0=geom.getCoordinates()[0];
        		Coordinate p1=geom.getCoordinates()[1];
        		Coordinate p2=geom.getCoordinates()[2];
        		return Triangle.isAcute(p0, p1, p2);
        	}
		}
		return false;
	}
}
