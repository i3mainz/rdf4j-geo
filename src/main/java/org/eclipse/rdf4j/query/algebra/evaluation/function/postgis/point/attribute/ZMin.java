package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class ZMin extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Geometry geo=geom;
        Double minZ=0.;
        for(Coordinate coord:geo.getCoordinates()) {
        	if(minZ>coord.getZ()) {
        		minZ=coord.getZ();
        	}
        }
        return minZ;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_zMin.stringValue();
	}

}
