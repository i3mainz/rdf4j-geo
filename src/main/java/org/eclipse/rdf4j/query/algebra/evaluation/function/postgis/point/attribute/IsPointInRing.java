package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.algorithm.CGAlgorithms;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class IsPointInRing extends GeometricRelationBinaryFunction{

	@Override
	public boolean relation(Geometry ringgeom,Geometry pointgeom) {
        CGAlgorithms algos=new CGAlgorithms();
        return algos.isPointInRing(pointgeom.getCoordinate(), ringgeom.getCoordinates());
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isPointInRing.stringValue();
	}

}
