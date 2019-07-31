package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.locationtech.jts.geom.Geometry;

public abstract class VectorLiteral implements LiteralType {

	public abstract String unparse(Geometry geom);
	
	public abstract Geometry read(String literalValue);
	
}
