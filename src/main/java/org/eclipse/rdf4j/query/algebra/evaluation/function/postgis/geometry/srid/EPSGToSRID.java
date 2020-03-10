package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;

public class EPSGToSRID implements Function {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return POSTGIS.EPSGToSRID.stringValue();
	}

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 1) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}			
		Integer srid=Integer.valueOf(args[0].stringValue().substring(args[0].stringValue().indexOf(':')+1));
		return valueFactory.createLiteral(srid);
	}

}

