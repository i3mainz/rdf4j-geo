package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleBinaryFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.operation.distance3d.Distance3DOp;

public class FullyWithinDistance3D extends GeometricRelationDoubleBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_fullyWithinDistance3D.stringValue();
	}

	@Override
	protected boolean relation(Geometry g1, Geometry g2, Double distance) {
        double maxdistance3d=getMaxDistance3D(g1,g2);
        if(maxdistance3d<=distance) {
        	return true;
        }
        return false;	
	}
	
	private double getMaxDistance3D(Geometry geom1,Geometry geom2) {
		Double maxDistance=0.;
        GeometryFactory fac=new GeometryFactory();
			for(Coordinate coord:geom1.getCoordinates()) {
				for(Coordinate coord2:geom2.getCoordinates()) {
					Double curdistance=Distance3DOp.distance(fac.createPoint(coord), fac.createPoint(coord2));
					if(curdistance>maxDistance) {
						maxDistance=curdistance;
					}
				}
			}
			return maxDistance;
	}

}
