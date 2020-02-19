package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class ForceCollection extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_forceCollection.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
         GeometryFactory fac=new GeometryFactory();
         return fac.createGeometryCollection(new Geometry[] {geom});
	}

}
