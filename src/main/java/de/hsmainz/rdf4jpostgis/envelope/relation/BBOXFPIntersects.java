package main.java.de.hsmainz.rdf4jpostgis.envelope.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationBinaryFunction;

public class BBOXFPIntersects extends GeometricRelationBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_bboxfpintersects.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom1, Geometry geom2) {
		Geometry transformed=LiteralUtils.transform(geom2, geom1);
		if(transformed.getPrecisionModel().isFloating()) {
			return geom1.getEnvelope().intersects(transformed.getEnvelope());
		}
		return false;
	}

}