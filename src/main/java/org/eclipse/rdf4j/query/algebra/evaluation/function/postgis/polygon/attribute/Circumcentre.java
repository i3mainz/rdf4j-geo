package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.Triangle;

/**
 * Calculates the circumcentre of a triangle.
 *
 */
public class Circumcentre extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_circumcentre.stringValue();
	}

	@Override
	public Geometry operation(Geometry geom) {
		if (geom instanceof Polygon) {
        	if(geom.getCoordinates().length==3) {
        		Coordinate p0=geom.getCoordinates()[0];
        		Coordinate p1=geom.getCoordinates()[1];
        		Coordinate p2=geom.getCoordinates()[2];
        		GeometryFactory fac=new GeometryFactory();
        		return fac.createPoint(Triangle.circumcentre(p0, p1, p2));
        	}
		}
		return null;
	}

}
