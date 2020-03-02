package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;


/**
 * Returns the nth geometry of a given geometry collection.
 */
public class GeometryN extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_geometryN.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
		return geom.getGeometryN(value);
	}

}
