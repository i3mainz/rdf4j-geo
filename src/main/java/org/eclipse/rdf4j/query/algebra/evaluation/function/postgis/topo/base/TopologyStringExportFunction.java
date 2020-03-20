package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.topo.base;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.topo.TopologyLiteral;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.VectorLiteral;
import org.locationtech.jts.geom.Geometry;

public abstract class TopologyStringExportFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		if (args.length != 1) {
			throw new ValueExprEvaluationException(getURI() + " requires exactly 1 arguments, got " + args.length);
		}
		LiteralType l=LiteralRegistry.getLiteral(((Literal)args[0]).getDatatype().toString());
		LiteralType l2=LiteralRegistry.getLiteral(((Literal)args[1]).getDatatype().toString());
		if(l instanceof TopologyLiteral && l2 instanceof VectorLiteral) {
			Topology topo=((TopologyLiteral)l).read(args[0].stringValue());
			String result = modify(topo);
			return valueFactory.createLiteral(result,((Literal)args[0]).getDatatype());
		}
		return null;
	}
	
	public abstract String modify(Topology topo);


}
