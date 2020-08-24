package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

public class MinkowskiDistance extends GeometricRelationDoubleDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_minkowskidistance.stringValue();
	}


	@Override
	protected double relation(Geometry geom1, Geometry geom2,Double power) {
		double sum=0.;
		for(Coordinate coord:geom1.getCoordinates()) {
			sum+=Math.pow(Math.abs(coord.y-coord.x), power);
		}
		return Math.pow(sum, 1 / power);    
	}


}
