package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

/**
 * Returns true if all exterior rings are oriented clockwise and all interior rings are oriented counter-clockwise. 
 *
 */
public class IsPolygonCW extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isPolygonCW.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
	     if (geom instanceof Polygon) {
	         return ((Polygon) geom).getNumInteriorRing();
	     }
	     return 0;
	}
}