package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleThreeGeometryFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

/**
 * Calculates an angle between three given points.
 */
public class Angle extends GeometricDoubleThreeGeometryFunction {

	/**
	 * Calculates an angle between three diffrent coordinates.
	 * @param a the first coordinate
	 * @param b the second coordinate
	 * @param c the third coordinate
	 * @return the calculated angle
	 */
	public double findAngle(Coordinate a,Coordinate b, Coordinate c) {
	    double AB = Math.sqrt(Math.pow(b.x-a.x,2)+ Math.pow(b.y-a.y,2));    
	    double BC = Math.sqrt(Math.pow(b.x-c.x,2)+ Math.pow(b.y-c.y,2)); 
	    double AC = Math.sqrt(Math.pow(c.x-a.x,2)+ Math.pow(c.y-a.y,2));
	    return Math.acos((BC*BC+AB*AB-AC*AC)/(2*BC*AB));
	}

	@Override
	public String getURI() {
		return POSTGIS.st_angle.stringValue();
	}

	@Override
	protected Double relation(Geometry geom, Geometry geom2, Geometry geom3) {
		Coordinate coord1,coord2,coord3;
		if("Point".equals(geom.getGeometryType())) {
			coord1=geom.getCoordinate();
		}else {
			coord1=geom.getCentroid().getCoordinate();
		}
		if("Point".equals(geom2.getGeometryType())) {
			coord2=geom2.getCoordinate();
		}else {
			coord2=geom2.getCentroid().getCoordinate();
		}
		if("Point".equals(geom3.getGeometryType())) {
			coord3=geom3.getCoordinate();
		}else {
			coord3=geom3.getCentroid().getCoordinate();
		}
		return findAngle(coord1,coord2,coord3);
	}
}
