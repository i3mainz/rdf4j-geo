package main.java.de.hsmainz.rdf4jpostgis.geometry.relation;

import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationBinaryFunction;

public class EqualSRS extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean relation(Geometry g1, Geometry g2) {
		return g1.getSRID()==g2.getSRID();
	}

}
