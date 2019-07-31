package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;

public class MaxDistance extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_maxDistance.stringValue();
	}

	@Override
	protected double relation(Geometry geom1, Geometry geom2) {
		Double maxDistance=0.;
			GeometryWrapper transGeom2 = geom2.transform(geom1.getSRID());
			for(Coordinate coord:geom1.getCoordinates()) {
				for(Coordinate coord2:transGeom2.getXYGeometry().getCoordinates()) {
					Double curdistance=coord.distance(coord2);
					if(curdistance>maxDistance) {
						maxDistance=curdistance;
					}
				}
			}
			return maxDistance;
	}

}
