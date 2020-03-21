package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.precision.GeometryPrecisionReducer;


public class AsTextRaw extends GeometricStringExportFunction {

	
	
	
	
		@Override
	public String getURI() {
		return POSTGIS.ST_ASTEXTRAW.stringValue();
	}
	@Override
	public String operation(Geometry geom) {
	    Geometry geom_mod=GeometryPrecisionReducer.reduce(geom, new PrecisionModel(PrecisionModel.FLOATING));
	    return geom_mod.toText();
	}

}
