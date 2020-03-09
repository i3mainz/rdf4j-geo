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

public abstract class GeometricDoubleThreeGeometryFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 3) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 3 arguments, got " + args.length);
		}		
		
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		LiteralType l2=LiteralRegistry.getLiteral(((Literal)args[1]).getDatatype().toString());
		LiteralType l3=LiteralRegistry.getLiteral(((Literal)args[2]).getDatatype().toString());
		if(l instanceof VectorLiteral && l2 instanceof VectorLiteral) {
			Geometry geom=((VectorLiteral)l).read(args[0].stringValue());
			Geometry geom2=((VectorLiteral)l2).read(args[1].stringValue());
			Geometry geom3=((VectorLiteral)l3).read(args[2].stringValue());
			Double result = relation(geom,geom2,geom3);
			return valueFactory.createLiteral(result);
		}
		throw new ValueExprEvaluationException("Argument given is not a geometry literal");
	}

	protected abstract Double relation(Geometry geom, Geometry geom2,Geometry geom3);

}
