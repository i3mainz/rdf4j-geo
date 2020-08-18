package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

/**
 * Returns the number of distinct interior rings.
 */
public class NumDistinctInteriorRings extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_numDistinctInteriorRings.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
	     if (geom instanceof Polygon) {
	         return ((Polygon) geom).getNumInteriorRing();
	     }
	     return 0;
	}

}
