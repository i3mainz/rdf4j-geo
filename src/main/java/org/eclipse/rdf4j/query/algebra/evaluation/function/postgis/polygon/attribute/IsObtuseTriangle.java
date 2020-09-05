package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

public class IsObtuseTriangle extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isObtuse.stringValue();
	}
	
	 static double lengthSquare(Coordinate p1, Coordinate p2) 
	    { 
	        double xDiff = p1.x- p2.x; 
	        double yDiff = p1.y- p2.y; 
	        return xDiff*xDiff + yDiff*yDiff; 
	    } 

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof Polygon) {
        	if(geom.getCoordinates().length==3) {
          		Coordinate A=geom.getCoordinates()[0];
        		Coordinate B=geom.getCoordinates()[1];
        		Coordinate C=geom.getCoordinates()[2];
        		double a2 = lengthSquare(B,C); 
        		double b2 = lengthSquare(A,C); 
        		double c2 = lengthSquare(A,B); 
        		      
        		// length of sides be a, b, c 
        		double a = Math.sqrt(a2); 
        		double b = Math.sqrt(b2); 
        		double c = Math.sqrt(c2); 
        		      
        		// From Cosine law 
        		double alpha = Math.acos((b2 + c2 - a2)/(2*b*c)); 
        		double betta = Math.acos((a2 + c2 - b2)/(2*a*c)); 
        		double gamma = Math.acos((a2 + b2 - c2)/(2*a*b)); 
        		      
        		// Converting to degree 
        		alpha = (alpha * 180 / Math.PI); 
        		betta = (betta * 180 / Math.PI); 
        		gamma = (gamma * 180 / Math.PI); 
  
        		if(alpha>90 || betta>90 || gamma>90)
        			return true;
        		return false;
        	}
		}
		return false;
	}

}
