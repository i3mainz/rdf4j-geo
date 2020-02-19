package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class ZMax extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Geometry geo=geom;
        Double maxZ=0.;
        for(Coordinate coord:geo.getCoordinates()) {
        	if(maxZ<coord.getZ()) {
        		maxZ=coord.getZ();
        	}
        }
        return maxZ;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_zMax.stringValue();
	}

}
