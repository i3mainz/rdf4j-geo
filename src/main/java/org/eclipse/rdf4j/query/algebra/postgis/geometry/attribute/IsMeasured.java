package org.eclipse.rdf4j.query.algebra.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsMeasured extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		Boolean isMeasured=true;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(Double.isNaN(coord.getM())) {
        		isMeasured=false;
        	}
        }
        return isMeasured;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isMeasured.stringValue();
	}
	

}
