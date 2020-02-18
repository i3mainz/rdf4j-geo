package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base;

import java.io.IOException;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.VectorLiteral;
import org.locationtech.jts.geom.Geometry;

public abstract class GeometricConstructorInteger implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 2) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}

		String input=args[0].stringValue();
		Integer srid = Integer.valueOf(args[1].stringValue());
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		if(l instanceof VectorLiteral) {
			Geometry result = construct(input,srid);
			return valueFactory.createLiteral(((VectorLiteral) l).unparse(result),((Literal)args[0]).getDatatype());
		}
		throw new ValueExprEvaluationException("Arguments given are not geometry literals");
	}
	
	public abstract Geometry construct(String input,Integer srid);

}
