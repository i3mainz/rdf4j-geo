package main.java.de.hsmainz.rdf4jpostgis.envelope.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXIsContainedBy extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_bboxiscontainedby.stringValue();
	}

	@Override
	protected boolean relation(Geometry g1, Geometry g2) {
		Geometry transformed=LiteralUtils.transform(g2, g1);
		return transformed.getEnvelope().contains(g1.getEnvelope());
	}

}
