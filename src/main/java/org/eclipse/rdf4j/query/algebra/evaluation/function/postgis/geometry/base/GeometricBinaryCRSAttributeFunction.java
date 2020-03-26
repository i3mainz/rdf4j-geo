package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base;

import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.VectorLiteral;
import org.locationtech.jts.geom.Geometry;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.util.FactoryException;

public abstract class GeometricBinaryCRSAttributeFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 2) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 2 arguments, got " + args.length);
		}
		
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		Integer srid=Integer.valueOf(args[1].stringValue());
		if(l instanceof VectorLiteral) {
			Geometry geom=((VectorLiteral)l).read(args[0].stringValue());
			boolean result;
			try {
				result = operation(geom,CRS.forCode("EPSG:"+srid));
				return valueFactory.createLiteral(result);
			} catch (FactoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	
		}
		throw new ValueExprEvaluationException("Arguments given are not geometry literals");
	}
	
	protected abstract boolean operation(Geometry g1,  CoordinateReferenceSystem crs);

}
