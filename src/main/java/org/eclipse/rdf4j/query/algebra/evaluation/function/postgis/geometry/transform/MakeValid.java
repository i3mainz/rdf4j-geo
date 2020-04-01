package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;

public class MakeValid extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_makeValid.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		if(geom.isValid())
			return geom;
        return null;
	}

}
