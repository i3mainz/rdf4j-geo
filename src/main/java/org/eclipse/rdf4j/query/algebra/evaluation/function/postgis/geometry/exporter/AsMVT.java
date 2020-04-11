package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.MVTDatatype;
import org.locationtech.jts.geom.Geometry;

public class AsMVT extends GeometricStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ASMVT.stringValue();
	}

	@Override
	public String operation(Geometry geom) {
		return MVTDatatype.INSTANCE.unparse(geom);
	}

}
