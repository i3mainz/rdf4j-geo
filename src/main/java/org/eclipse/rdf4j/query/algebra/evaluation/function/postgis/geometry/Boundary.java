package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.BoundaryOp;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Boundary extends GeometricUnaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.ST_BOUNDARY.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
        BoundaryOp boundop=new BoundaryOp(geom);
        return boundop.getBoundary();     
	}

}
