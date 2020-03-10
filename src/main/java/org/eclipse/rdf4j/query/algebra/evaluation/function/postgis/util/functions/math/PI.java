package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.functions.math;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;

public class PI implements Function {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return POSTGIS.Log.stringValue();
	}

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {		
		return valueFactory.createLiteral(Math.PI);
	}

}
