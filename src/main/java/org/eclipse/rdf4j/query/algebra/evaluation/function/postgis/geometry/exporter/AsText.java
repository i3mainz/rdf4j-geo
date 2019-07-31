package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class AsText extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
         return geom.toText();
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASTEXT.stringValue();
	}

}
