package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.operation.distance.DistanceOp;

public class ClosestPoint extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_CLOSESTPOINT.stringValue();
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry g2) {
		DistanceOp distop = new DistanceOp(g1, g2);
		Coordinate[] coords = distop.nearestPoints();
		Coordinate coord = new Coordinate(coords[0].x, coords[0].y);
		GeometryFactory fac=new GeometryFactory();
		return fac.createPoint(coord);
	}

}



