package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationDoubleFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

public class ManhattanDistance extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_manhattandistance.stringValue();
	}


	@Override
	protected double relation(Geometry geom1, Geometry geom2) {
		Coordinate coord1=null,coord2=null;
		if(geom1 instanceof Point) {
			coord1=((Point)geom1).getCoordinate();
		}else {
			coord1=geom1.getCentroid().getCoordinate();
		}
		if(geom2 instanceof Point) {
			coord1=((Point)geom2).getCoordinate();
		}else {
			coord1=geom2.getCentroid().getCoordinate();
		}		
	    return Math.abs(coord1.x - coord2.x) + Math.abs(coord1.y - coord2.y);       
	}

	
	
	
	
	

}
