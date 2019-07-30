package main.java.de.hsmainz.rdf4jpostgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationDoubleFunction;

public class CentroidDistance extends GeometricRelationDoubleFunction{

	@Override
	public String getURI() {
		return POSTGIS.ST_CENTROIDDISTANCE.stringValue();
	}

	@Override
	protected double relation(Geometry g1, Geometry g2) {
		return g1.getCentroid().distance(g2.getCentroid());
	}

}
