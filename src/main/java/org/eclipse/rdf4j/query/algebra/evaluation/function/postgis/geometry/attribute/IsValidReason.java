package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.valid.IsValidOp;
import org.locationtech.jts.operation.valid.TopologyValidationError;

public class IsValidReason extends GeometricStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isValidReason.stringValue();
	}

	@Override
	public String operation(Geometry geom) {
	     IsValidOp isvalid = new IsValidOp(geom);
	     TopologyValidationError error = isvalid.getValidationError();
	     if (error != null) {
	         return error.toString();
	     } else {
	         return "Valid Geometry";
	     }
	}

}
