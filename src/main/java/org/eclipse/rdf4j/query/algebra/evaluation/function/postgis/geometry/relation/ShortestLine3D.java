package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.distance3d.Distance3DOp;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationModifierFunction;

public class ShortestLine3D extends GeometricRelationModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_shortestLine3D.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
			Geometry transformed=LiteralUtils.transform(geom2, geom1);
            Distance3DOp distop = new Distance3DOp(geom1, transformed);
            Coordinate[] coord = distop.nearestPoints();
            return LiteralUtils.createGeometry(coord, "LINESTRING", geom1.getSRID());
	}

}
