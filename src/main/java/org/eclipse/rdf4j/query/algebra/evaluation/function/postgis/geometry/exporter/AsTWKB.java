package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.TWKBDatatype;
import org.locationtech.jts.geom.Geometry;


/**
 * Returns a TinyWKB representation of a given geometry.
 */
public class AsTWKB extends GeometricStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ASTWKB.stringValue();
	}

	@Override
	public String operation(Geometry geom) {
		TWKBDatatype lit=new TWKBDatatype();
		return lit.unparse(geom);
	}

}
