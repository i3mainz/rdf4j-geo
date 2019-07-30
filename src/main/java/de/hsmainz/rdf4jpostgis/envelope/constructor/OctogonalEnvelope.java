package main.java.de.hsmainz.rdf4jpostgis.envelope.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.OctagonalEnvelope;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class OctogonalEnvelope extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_octogonalEnvelope.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		return LiteralUtils.toGeometry(new OctagonalEnvelope(geom));

	}

}
