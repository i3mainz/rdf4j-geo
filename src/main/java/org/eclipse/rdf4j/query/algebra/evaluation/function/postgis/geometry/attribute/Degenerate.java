package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Geometry;

public class Degenerate extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isDegenerate.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		return !geom.isValid();
	}

}
