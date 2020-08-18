package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.algorithm.CGAlgorithms;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

/**
 * Returns true if a given point is found on a given LineString.
 */
public class IsPointOnLine extends GeometricRelationBinaryFunction{

	@Override
	protected boolean relation(Geometry linegeom, Geometry pointgeom) {
		CGAlgorithms algos=new CGAlgorithms();
        return algos.isOnLine(pointgeom.getCoordinate(), linegeom.getCoordinates());
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isPointOnLine.stringValue();
	}
	
}
