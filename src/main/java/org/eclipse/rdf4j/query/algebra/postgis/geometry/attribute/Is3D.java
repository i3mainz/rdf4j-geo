package org.eclipse.rdf4j.query.algebra.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class Is3D extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_is3D.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		Boolean is3D=true;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(Double.isNaN(coord.getZ())) {
        		is3D=false;
        	}
        }
        return is3D;
	}


}