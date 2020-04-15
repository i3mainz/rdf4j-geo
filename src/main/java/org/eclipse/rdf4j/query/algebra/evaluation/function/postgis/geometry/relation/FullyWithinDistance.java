package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleBinaryFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

public class FullyWithinDistance extends GeometricRelationDoubleBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_DWITHIN.stringValue();
	}

	@Override
	protected boolean relation(Geometry g1, Geometry g2, Double distance) {
		double maxdistance=getMaxDistance(g1,g2);
		if(distance<=maxdistance) {
			return true;
		}
		return false;
	}

	private double getMaxDistance(Geometry geom1,Geometry geom2) {
		Double maxDistance=0.;
		Geometry transformed=LiteralUtils.transform(geom2, geom1);
			for(Coordinate coord:geom1.getCoordinates()) {
				for(Coordinate coord2:transformed.getCoordinates()) {
					Double curdistance=coord.distance(coord2);
					if(curdistance>maxDistance) {
						maxDistance=curdistance;
					}
				}
			}
			return maxDistance;
	}
	
}
