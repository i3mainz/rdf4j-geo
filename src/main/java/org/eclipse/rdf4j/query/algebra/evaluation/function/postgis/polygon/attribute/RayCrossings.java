package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;
import org.locationtech.jts.algorithm.RayCrossingCounter;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

public class RayCrossings extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rayCrossings.stringValue();
	}

	@Override
	public double relation(Geometry point,Geometry geom) {
		RayCrossingCounter counter=new RayCrossingCounter(point.getCoordinate());
		return 0.;
	}

}
