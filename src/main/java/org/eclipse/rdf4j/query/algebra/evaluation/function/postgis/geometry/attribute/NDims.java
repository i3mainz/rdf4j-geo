package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;

/**
 * Returns the minimum of dimensions of the given geometry.
 */
public class NDims extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_nDims.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
		return geom.getDimension();
	}

}
