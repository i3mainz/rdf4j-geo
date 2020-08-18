package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

/**
 * Checks if the given polygon is a right triangle.
 */
public class IsRightTriangle extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isRightTriangle.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof Polygon) {
        	if(geom.getCoordinates().length==3) {
        		return isRightAngledTriangle(geom.getCoordinates());
        	}
		}
		return false;
	}

	/**
	 * Checks if a polygon with three coordinates is a right triangle.
	 * @param coords the coordinates to be analyzed
	 * @return true if the triangle is right angled
	 */
	public boolean isRightAngledTriangle(Coordinate[] coords){
		Coordinate a=coords[0];
		Coordinate b=coords[1];
		Coordinate c=coords[2];
	    Double lengthA = getLength(a,b);
	    Double lengthB = getLength(b,c);
	    Double lengthC = getLength(c,a);
	    return  Math.pow(lengthA, 2) + Math.pow(lengthB, 2) == Math.pow(lengthC, 2) ||
	            Math.pow(lengthA, 2) + Math.pow(lengthC, 2) == Math.pow(lengthB, 2) ||
	            Math.pow(lengthC, 2) + Math.pow(lengthB, 2) == Math.pow(lengthA, 2);
	}
	
	/**
	 * Calculates the length of an edge of a triangle.
	 * @param point1 the beginning point of the edge
	 * @param point2 the end point of the edge
	 * @return the length of the edge
	 */
	public double getLength(Coordinate point1 , Coordinate point2){
	    return Math.sqrt((point2.getX()-point1.getX())*(point2.getX()-point1.getX()) + (point2.getY()-point1.getY())*(point2.getY()-point1.getY()));
	}
	
}
