package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.RasterLiteral;

public abstract class RasterAttributeIntIntFunction implements Function {
	
	@Override
public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
	if (args.length != 2) {
		throw new ValueExprEvaluationException(getURI() + " requires exactly 2 arguments, got " + args.length);
	}
	LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
	if(l instanceof RasterLiteral) {
		GridCoverage geom=((RasterLiteral)l).read(args[0].stringValue());
		Integer parameter = Integer.valueOf(args[1].stringValue());
		Integer result = attribute(geom,parameter);
		return valueFactory.createLiteral(result);
	}
	return null;
}

public abstract Integer attribute(GridCoverage geom,Integer param);


}
