package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;

/**
 * Returns true if the given geometry is an instance of GeometryCollection, CompoundCurve or a MULTI type.
 */
public class IsCollection extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isCollection.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
        String type=geom.getGeometryType().toUpperCase();
        if("GEOMETRYCOLLECTION".equals(type) || "COMPOUNDCURVE".equals(type) || type.startsWith("MULTI")) {
            return true;
        }
        return false;
    
	}

}
