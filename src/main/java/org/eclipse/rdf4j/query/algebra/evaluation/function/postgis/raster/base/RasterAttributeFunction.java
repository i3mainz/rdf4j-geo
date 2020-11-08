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

public abstract class RasterAttributeFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 1) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}
		System.out.println(((Literal)args[0]).getDatatype().toString());
		System.out.println(LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString()));
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		System.out.println(l);
		if(l instanceof RasterLiteral) {
			GridCoverage geom=((RasterLiteral)l).read(args[0].stringValue());
			//System.out.println("Extracted GridCoverage: "+geom);
			Double result = attribute(geom);
			return valueFactory.createLiteral(result);
		}
		return null;
	}
	
	public abstract Double attribute(GridCoverage geom);
	
}
