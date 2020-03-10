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

public abstract class RasterAlgebraFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 4) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		LiteralType l2=LiteralRegistry.getLiteral(((Literal)args[2]).getDatatype().toString());
		if(l instanceof RasterLiteral && l2 instanceof RasterLiteral) {
			GridCoverage geom=((RasterLiteral)l).read(args[0].stringValue());
			Integer bd1=Integer.valueOf(args[1].stringValue());
			GridCoverage geom2=((RasterLiteral)l).read(args[2].stringValue());
			Integer bd2=Integer.valueOf(args[3].stringValue());
			GridCoverage result = modify(geom,bd1,geom2,bd2);
			return valueFactory.createLiteral(((RasterLiteral) l).unparse(result),((Literal)args[0]).getDatatype());
		}
		return null;
	}
	
	public abstract GridCoverage modify(GridCoverage coverage,Integer bd1, GridCoverage coverage2,Integer bd2);

}
