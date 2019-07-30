package main.java.de.hsmainz.rdf4jpostgis.envelope.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXOverlapsLeft extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_bboxoverlapsleft.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom, Geometry g2) {
		Geometry transformed=LiteralUtils.transform(g2, geom);
		if(geom.getEnvelope().overlaps(transformed.getEnvelope())) {
			return true;
		}
		if(geom.getEnvelopeInternal().getMaxX()<transformed.getEnvelopeInternal().getMinX()) {
			return true;
		}
		return false;
	}

}
