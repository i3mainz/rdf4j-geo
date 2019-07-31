package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class XMin extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Geometry geo=geom;
        Double minX=0.;
        for(Coordinate coord:geo.getCoordinates()) {
        	if(minX>coord.getX()) {
        		minX=coord.getX();
        	}
        }
        return minX;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_xMin.stringValue();
	}

}
