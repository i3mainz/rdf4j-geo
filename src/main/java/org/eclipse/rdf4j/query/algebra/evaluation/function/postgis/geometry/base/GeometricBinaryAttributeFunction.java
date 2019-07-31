package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base;

import java.io.IOException;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.FunctionArguments;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.shape.Shape;

public abstract class GeometricBinaryAttributeFunction implements Function {

	
	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 1) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}

		args[0].
		
		SpatialContext geoContext = SpatialSupport.getSpatialContext();
		Geometry geom1 = FunctionArguments.getShape(this, args[0], geoContext);

		boolean result = attribute(geom1);
		return valueFactory.createLiteral(result);
	}
	
	public abstract boolean attribute(Geometry geom);
	

}