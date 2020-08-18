package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.algorithm.Orientation;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

/**
 * Returns true if all exterior rings are oriented clockwise and all interior rings are oriented clockwise. 
 */
public class IsPolygonCW extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isPolygonCW.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
	     if (geom instanceof Polygon) {
	         return !Orientation.isCCW(geom.getCoordinates());
	     }
	     return false;
	}
}