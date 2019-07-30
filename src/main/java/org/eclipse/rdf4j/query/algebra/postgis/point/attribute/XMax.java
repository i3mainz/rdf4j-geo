package org.eclipse.rdf4j.query.algebra.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricDoubleAttributeFunction;
import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricUnaryFunction;

public class XMax extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_xMax.stringValue();
	}

	@Override
	public double attribute(Geometry geom) {
	        Double maxX=0.;
	        for(Coordinate coord:geom.getCoordinates()) {
	        	if(maxX<coord.getX()) {
	        		maxX=coord.getX();
	        	}
	        }
	        return maxX;
	}

}
