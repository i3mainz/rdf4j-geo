package main.java.de.hsmainz.rdf4jpostgis.geometry.relation;

import org.locationtech.jts.algorithm.distance.DiscreteHausdorffDistance;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationDoubleFunction;

public class HausdorffDistance extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected double relation(Geometry g1, Geometry g2) {
        DiscreteHausdorffDistance distance = new DiscreteHausdorffDistance(g1, g2);
        return distance.distance();

	}

}
