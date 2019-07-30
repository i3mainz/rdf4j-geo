package main.java.de.hsmainz.rdf4jpostgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationBinaryFunction;

public class EqualSRS extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_equalSRS.stringValue();
	}

	@Override
	protected boolean relation(Geometry g1, Geometry g2) {
		return g1.getSRID()==g2.getSRID();
	}

}
