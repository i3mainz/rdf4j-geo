package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;

public class MakeBox2D extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_makeBox2D.stringValue();
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry g2) {
            Envelope box2d=new Envelope(g1.getCoordinate(),g2.getCoordinate());
            return LiteralUtils.toGeometry(box2d);
	}

}
