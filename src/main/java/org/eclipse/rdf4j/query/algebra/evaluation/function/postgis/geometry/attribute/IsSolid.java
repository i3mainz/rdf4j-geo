package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

/**
 * Returns true if the given geometry is solid. Equivalent to ST_Is3D.
 */
public class IsSolid extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isSolid.stringValue();
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
