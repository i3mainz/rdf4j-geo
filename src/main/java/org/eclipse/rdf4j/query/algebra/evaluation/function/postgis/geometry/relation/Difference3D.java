package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.distance3d.Distance3DOp;

public class Difference3D extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		return "";
	}

	@Override
	protected double relation(Geometry geom1, Geometry g2) {
		Geometry transformed=LiteralUtils.transform(g2, geom1);
            Distance3DOp op3d=new Distance3DOp(geom1, transformed);
            double distance3d=op3d.distance();
            return distance3d; 
	}

}
