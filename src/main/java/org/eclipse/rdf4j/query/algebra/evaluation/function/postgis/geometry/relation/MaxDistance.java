package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;

public class MaxDistance extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_maxDistance.stringValue();
	}

	@Override
	protected double relation(Geometry geom1, Geometry geom2) {
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
