package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

/**
 * Creates a LineString from a given MultiPoint representation.
 */
public class LineFromMultiPoint extends GeometricUnaryFunction {


	@Override
	protected Geometry operation(Geometry geom) {
		if("MultiPoint".equals(geom.getGeometryType())){
			return LiteralUtils.createGeometry(geom.getCoordinates(), "LINESTRING", geom.getSRID());
		}	
		return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_lineFromMultiPoint.stringValue();
	}

}
