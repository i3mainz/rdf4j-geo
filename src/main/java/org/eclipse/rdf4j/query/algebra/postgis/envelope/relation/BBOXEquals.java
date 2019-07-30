package main.java.de.hsmainz.rdf4jpostgis.envelope.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXEquals extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_bboxequals.stringValue();
	}

	@Override
	protected boolean relation(Geometry g1, Geometry g2) {
		Geometry transformed=LiteralUtils.transform(g2, g1);
		return g1.getEnvelope().equals(transformed.getEnvelope());
	}

}
