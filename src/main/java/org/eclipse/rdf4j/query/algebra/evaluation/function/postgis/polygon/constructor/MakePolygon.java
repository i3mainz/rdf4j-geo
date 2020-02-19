package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;
import org.locationtech.jts.geom.Geometry;

public class MakePolygon extends GeometricConstructor{

	@Override
	public String getURI() {
		return POSTGIS.st_makePolygon.stringValue();
	}

	@Override
	public Geometry construct(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
