package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;
import org.locationtech.jts.geom.Geometry;

/**
 * Creates a LineString from a given geometry.
 */
public class MakeLine extends GeometricConstructor {

	@Override
	public String getURI() {
		return POSTGIS.st_makeLine.stringValue();
	}

	@Override
	public Geometry construct(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
