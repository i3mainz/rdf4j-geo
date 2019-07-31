package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base;

import java.io.IOException;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.GEO;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.shape.Shape;

public abstract class GeometricUnaryFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 2) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 2 arguments, got " + args.length);
		}

		SpatialContext geoContext = SpatialSupport.getSpatialContext();
		Geometry geom1 = FunctionArguments.getShape(this, args[0], geoContext);

		String wkt;
		try {
			Geometry result = operation(geom1);
			wkt = result.toText();
		} catch (IOException | RuntimeException e) {
			throw new ValueExprEvaluationException(e);
		}
		return valueFactory.createLiteral(wkt, GEO.WKT_LITERAL);
	}

	protected abstract Geometry operation(Geometry geom);
}

