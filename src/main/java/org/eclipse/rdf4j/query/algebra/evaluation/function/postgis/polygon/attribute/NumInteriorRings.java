package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;

public class NumInteriorRings extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_numInteriorRings.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
		if(geom instanceof Polygon) {
			Polygon poly=(Polygon)geom;
			Set<Geometry> coordset=new HashSet<Geometry>();
			for(int i=0;i<poly.getNumInteriorRing();i++) {
				coordset.add(geom.getGeometryN(i));
			}
			return coordset.size();
		}
		return 0;
		
	}

}
