package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

/**
 * Returns minimum y coordinate of the given geometry.
 */
public class YMin extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Double minY=Double.MAX_VALUE;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(minY>coord.getY()) {
        		minY=coord.getY();
        	}
        }
        return minY;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_yMin.stringValue();
	}

}
