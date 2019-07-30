package org.eclipse.rdf4j.query.algebra.postgis.util;

import java.io.IOException;
import java.text.ParseException;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.vocabulary.GEO;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.exception.InvalidShapeException;
import org.locationtech.spatial4j.io.ShapeReader;
import org.locationtech.spatial4j.shape.Shape;

public class FunctionArguments {

	public static Shape getShape(Function func, Value v, SpatialContext context) throws ValueExprEvaluationException {
		Literal wktLiteral = getLiteral(func, v, GEO.WKT_LITERAL);
		try {
			ShapeReader reader = context.getFormats().getWktReader();
			return reader.read(wktLiteral.getLabel());
		} catch (IOException | InvalidShapeException | ParseException e) {
			throw new ValueExprEvaluationException("Invalid argument for " + func.getURI() + ": " + wktLiteral, e);
		}
	}
	
}
