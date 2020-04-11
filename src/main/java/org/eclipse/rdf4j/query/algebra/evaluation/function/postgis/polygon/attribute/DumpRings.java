package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

public class DumpRings extends GeometricStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_dumprings.stringValue();
	}

	@Override
	public String operation(Geometry geom) {
		Polygon poly=(Polygon) geom;
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<poly.getNumInteriorRing();i++) {
			builder.append(poly.toText()+System.lineSeparator());
		}
		return builder.toString();
	}


}
