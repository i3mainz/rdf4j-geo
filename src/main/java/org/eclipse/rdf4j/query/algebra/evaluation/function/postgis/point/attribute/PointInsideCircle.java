package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleDoubleDoubleFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.util.GeometricShapeFactory;

/**
 * Returns true if a point is found within the bounds of a given circle defintion.
 */
public class PointInsideCircle extends GeometricModifierDoubleDoubleDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_pointInsideCircle.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom, Double centerx, Double centery, Double radius) {
		 if("POINT".equals(geom.getGeometryType().toUpperCase())){
	         	GeometricShapeFactory shapeFactory = new GeometricShapeFactory();
	             shapeFactory.setNumPoints(32);
	             shapeFactory.setCentre(new Coordinate(centerx, centery));
	             shapeFactory.setSize(radius * 2);
	             Polygon circle=shapeFactory.createCircle();
	             return circle.contains(geom);
	     }
		 return false;
	}

}
