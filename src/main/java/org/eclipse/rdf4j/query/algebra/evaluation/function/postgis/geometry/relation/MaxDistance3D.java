package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.operation.distance3d.Distance3DOp;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;

public class MaxDistance3D extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_maxDistance3D.stringValue();
	}

	@Override
	protected double relation(Geometry geom1, Geometry geom2) {
		Geometry transformed=LiteralUtils.transform(geom2, geom1);
		Double maxDistance=0.;
        GeometryFactory fac=new GeometryFactory();
			for(Coordinate coord:geom1.getCoordinates()) {
				for(Coordinate coord2:transformed.getCoordinates()) {
					Double curdistance=Distance3DOp.distance(fac.createPoint(coord), fac.createPoint(coord2));
					if(curdistance>maxDistance) {
						maxDistance=curdistance;
					}
				}
			}
			return maxDistance;
	}

}
