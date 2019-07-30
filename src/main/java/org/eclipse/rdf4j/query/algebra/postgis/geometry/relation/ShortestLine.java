package org.eclipse.rdf4j.query.algebra.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.distance.DistanceOp;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricRelationModifierFunction;

public class ShortestLine extends GeometricRelationModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_shortestLine.stringValue();
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry g2) {
		 Geometry transformed=LiteralUtils.transform(g2, g1);
		 DistanceOp distop = new DistanceOp(g1, transformed);
         Coordinate[] coord = distop.nearestPoints();
         return LiteralUtils.createGeometry(coord, "LINESTRING", g1.getSRID());
	}

}
