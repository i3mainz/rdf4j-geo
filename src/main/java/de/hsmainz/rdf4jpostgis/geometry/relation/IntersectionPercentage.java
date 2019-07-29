package main.java.de.hsmainz.rdf4jpostgis.geometry.relation;

import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationDoubleFunction;

public class IntersectionPercentage extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double relation(Geometry geom1, Geometry geom2) {
		Double db;
		db = (geom1.intersection(geom2).getArea()/geom2.getArea());
	    if(db.equals(Double.NaN)){
	    	return 0.;
	    }
	    return db;
	}

}
