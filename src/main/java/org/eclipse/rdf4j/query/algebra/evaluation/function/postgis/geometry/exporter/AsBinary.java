package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;


import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKBDatatype;

/**
 * Returns a WKB representation of a given geometry.
 */
public class AsBinary extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		return WKBDatatype.INSTANCE.unparse(geom);
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASBINARY.stringValue();
	}
	
	

}
