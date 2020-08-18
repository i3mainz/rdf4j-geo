package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import java.util.Arrays;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.operation.valid.IsValidOp;
import org.locationtech.jts.operation.valid.TopologyValidationError;

/**
 * Checks if the given geometry is valid and gives more details on a possible validation error.
 */
public class IsValidDetail extends GeometricStringExportFunction {
	
	@Override
	public String getURI() {
		return POSTGIS.st_isValidDetail.stringValue();
	}
	@Override
	public String operation(Geometry geom) {
	    Object[] details = new Object[3];
	    IsValidOp validOP = new IsValidOp(geom);
	    GeometryFactory fac=new GeometryFactory();
	    TopologyValidationError error = validOP.getValidationError();
	    if (error != null) {
	        details[0] = false ;
	        details[1] = error.getMessage();
	        details[2] = fac.createPoint(error.getCoordinate());
	    } else {
	        details[0] = true ;
	        details[1] = "Valid Geometry";
	    }
	    return Arrays.toString(details);
	}
}
