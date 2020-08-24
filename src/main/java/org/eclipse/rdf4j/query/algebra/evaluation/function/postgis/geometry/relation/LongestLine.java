package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationModifierFunction;

public class LongestLine extends GeometricRelationModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_longestLine.stringValue();
	}


	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
		Double maxDistance=0.;
        Coordinate maxCoord1=null;
        Coordinate maxCoord2=null;
		for(Coordinate coord:geom1.getCoordinates()) {
			for(Coordinate coord2:geom2.getCoordinates()) {
				Double curdistance=coord.distance(coord2);
				if(curdistance>maxDistance) {
					maxDistance=curdistance;
					maxCoord1=coord;
					maxCoord2=coord2;
				}
			}
		}
		return LiteralUtils.createGeometry(new Coordinate[] {maxCoord1,maxCoord2},"LineString", geom1.getSRID());
	}
}
