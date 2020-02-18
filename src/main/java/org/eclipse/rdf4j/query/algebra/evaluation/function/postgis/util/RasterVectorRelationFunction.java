package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util;

import java.util.Set;
import java.util.TreeSet;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.locationtech.jts.geom.Geometry;

public abstract class RasterVectorRelationFunction implements Function {


	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract Geometry relation(Value v1,Value v2);

	
	public static Set<String> rasterLiteralURIs=new TreeSet<String>();

	public static Set<String> vectorLiteralURIs=new TreeSet<String>();
	
	public static Boolean vectorOrRaster(Literal lit) {
		if(rasterLiteralURIs.contains(lit.getDatatype())) {
			return false;
		}else if(vectorLiteralURIs.contains(lit.getDatatype())) {
			return true;
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
