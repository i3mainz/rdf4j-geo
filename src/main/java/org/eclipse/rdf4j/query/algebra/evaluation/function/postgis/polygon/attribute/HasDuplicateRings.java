package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

public class HasDuplicateRings extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_hasDuplicateRings.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		Polygon poly=(Polygon) geom;
		for(int i=0;i<poly.getNumInteriorRing();i++) {
			for(int j=0;j<poly.getNumInteriorRing();j++) {
				if(poly.getInteriorRingN(i).equals(poly.getInteriorRingN(j))) {
					return true;
				}
			}
		}
		return false;
	}

}
