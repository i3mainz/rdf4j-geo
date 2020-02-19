package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;
import org.locationtech.jts.geom.Geometry;

public class Area3D extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_AREA3D.stringValue();
	}

	@Override
	public double attribute(Geometry geom) {
		// TODO Auto-generated method stub
		return 0;
	}

}
