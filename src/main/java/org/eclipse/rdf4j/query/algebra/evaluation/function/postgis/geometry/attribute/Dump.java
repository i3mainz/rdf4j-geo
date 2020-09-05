package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;


public class Dump extends GeometricStringExportFunction {

	
	@Override
	public String getURI() {
		return POSTGIS.st_dump.stringValue();
	}

	@Override
	public String operation(org.locationtech.jts.geom.Geometry geom) {
	     List<String> results = new ArrayList<>(geom.getNumGeometries());
	     for (int i = 0; i < geom.getNumGeometries(); i++) {
	         Geometry res = geom.getGeometryN(i);
	         String resString = res.toText();
	         results.add(resString);
	     }
	     return String.join(" ", results);
	}

}
