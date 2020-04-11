package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

public class IsEquilateralTriangle extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isEquilateralTriangle.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof Polygon) {
        	if(geom.getCoordinates().length==3) {
        		Coordinate p0=geom.getCoordinates()[0];
        		Coordinate p1=geom.getCoordinates()[1];
        		Coordinate p2=geom.getCoordinates()[2];
        		double len0 = p1.distance(p2);
        	    double len1 = p0.distance(p2);
        	    double len2 = p0.distance(p1);
        	    if (len0 == len1 && len1 == len2 && len2 == len0)
        	        return true;
        	    else
        	        return false;
        	}
		}
		return false;
	}

}
