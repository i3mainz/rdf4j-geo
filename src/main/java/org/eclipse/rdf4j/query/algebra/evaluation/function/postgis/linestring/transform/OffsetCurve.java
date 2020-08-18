package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.buffer.BufferParameters;
import org.locationtech.jts.operation.buffer.OffsetCurveBuilder;

/**
 * Calculates an offset curve from a given geometry and a given distance.
 */
public class OffsetCurve extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_offsetCurve.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double distance) {
        BufferParameters bufParams = new BufferParameters();
        OffsetCurveBuilder ocb = new OffsetCurveBuilder(geom.getFactory().getPrecisionModel(), bufParams);
        Coordinate[] pts = ocb.getOffsetCurve(geom.getCoordinates(), distance);
        Geometry curve = geom.getFactory().createLineString(pts);
        return curve;
	}

}
