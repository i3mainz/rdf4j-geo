package org.eclipse.rdf4j.query.algebra.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricUnaryFunction;

public class Reverse extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_reverse.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {		
        Geometry reverseGeom = geom.reverse();
        return reverseGeom;
	}

}
