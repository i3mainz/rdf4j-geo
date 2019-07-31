package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util;

import java.util.Set;
import java.util.TreeSet;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.RasterLiteral;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.VectorLiteral;

public abstract class RasterVectorRelationBinaryFunction implements Function {
	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract Boolean relation(Value v1,Value v2);

	
	public static Set<String> rasterLiteralURIs=new TreeSet<String>();

	public static Set<String> vectorLiteralURIs=new TreeSet<String>();
	
	public static Boolean vectorOrRaster(Literal lit) {
		if(LiteralRegistry.literals.containsKey(lit.getDatatype().toString())) {
			LiteralType lite=LiteralRegistry.literals.get(lit.getDatatype().toString());
			if(lite instanceof VectorLiteral) {
				return true;
			}else if(lite instanceof RasterLiteral) {
				return false;
			}
		}
		return null;
	}
	
	public static Literal getLiteral(Function func, Value v) throws ValueExprEvaluationException {
		if (!(v instanceof Literal)) {
			throw new ValueExprEvaluationException("Invalid argument for " + func.getURI() + ": " + v);
		}
		Literal lit = (Literal) v;
		return lit;
	}


}
