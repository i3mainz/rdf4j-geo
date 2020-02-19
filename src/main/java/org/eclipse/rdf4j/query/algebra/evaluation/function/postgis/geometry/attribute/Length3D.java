package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class Length3D extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_Length3D.stringValue();
	}

}
