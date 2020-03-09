package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.functions;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;

public class ATan implements Function {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return POSTGIS.ATan.stringValue();
	}

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 1) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}			
		Double value=Double.valueOf(args[0].stringValue());
		return valueFactory.createLiteral(Math.atan(value));
	}

}
