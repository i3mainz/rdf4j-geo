package main.java.de.hsmainz.rdf4jpostgis.envelope.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXOverlapsRight extends GeometricRelationBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_bboxoverlapsright.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom, Geometry g2) {
		Geometry transformed=LiteralUtils.transform(geom, g2);
		if(geom.getEnvelope().overlaps(transformed.getEnvelope())) {
			return true;
		}
		if(geom.getEnvelopeInternal().getMinX()>transformed.getEnvelopeInternal().getMaxX()) {
			return true;
		}
		return false;
		
	}

}
