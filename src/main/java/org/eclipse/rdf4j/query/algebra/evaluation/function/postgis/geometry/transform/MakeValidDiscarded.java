package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class MakeValidDiscarded extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_makeValidDiscarded.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		GeometryFactory fac=new GeometryFactory();
		if(geom.isValid())
			return fac.createGeometry(null);
        return null;
	}

}
