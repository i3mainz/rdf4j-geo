package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

public class InteriorRingN extends GeometricModifierIntegerFunction  {


	@Override
	public String getURI() {
		return POSTGIS.st_interiorRingN.stringValue();
	}


	@Override
	protected Geometry relation(Geometry geom, Integer ringN) {
		if (geom instanceof Polygon) {
        	LineString result=((Polygon) geom).getInteriorRingN(ringN.intValue());
        	return result;
        }
		return null;
	}

}
