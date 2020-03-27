package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public class FurthestCoordinate extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_furthestcoordinate.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
		GeometryFactory fac=new GeometryFactory();
        	Point point;
        	if(geom1 instanceof Point) {
        		point=(Point)geom1;
        	}else {

        		point=fac.createPoint(geom1.getCoordinates()[0]);
        	}
			Double maxDistance=0.;
			Coordinate maxDistanceCoord=null;
	        for(Coordinate coord:geom2.getCoordinates()) {
	        	Double dist=point.getCoordinate().distance(coord);
	        	if(dist>maxDistance) {
	        		maxDistance=dist;
	        		maxDistanceCoord=coord;
	        	}
	        }
	        Point pointt=fac.createPoint(maxDistanceCoord);
	        pointt.setSRID(geom1.getSRID());
	        return pointt;
	}

}
