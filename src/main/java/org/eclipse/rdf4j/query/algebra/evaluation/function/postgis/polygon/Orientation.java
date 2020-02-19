package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;

public class Orientation extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_orientation.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
        if (geom instanceof Polygon) {
        	if(org.locationtech.jts.algorithm.Orientation.isCCW(geom.getCoordinates())) {
        		return -1;
        	}
            return 1;
        }
        return 0;
	}

}
