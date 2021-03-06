package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

/**
 * Returns maximum m coordinate of the given geometry.
 */
public class MMax extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
        Double maxM=0.;
        for(Coordinate coord:geom.getCoordinates()) {
        	if(maxM<coord.getM()) {
        		maxM=coord.getM();
        	}
        }
        return maxM;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_mMax.stringValue();
	}

}
