package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.VectorLiteral;
import org.locationtech.jts.geom.Geometry;

public abstract class GeometricModifierDoubleDoubleDoubleFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 4) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 3 arguments, got " + args.length);
		}

		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		Double value=Double.valueOf(args[1].stringValue());
		Double value2=Double.valueOf(args[2].stringValue());
		Double value3=Double.valueOf(args[3].stringValue());
		if(l instanceof VectorLiteral) {
			Geometry geom=((VectorLiteral)l).read(args[0].stringValue());
			Boolean result = relation(geom,value,value2,value3);
			return valueFactory.createLiteral(result);
		}
		throw new ValueExprEvaluationException("Argument given is not a geometry literal");
	}

	protected abstract boolean relation(Geometry geom, Double value,Double value2,Double value3);

}
