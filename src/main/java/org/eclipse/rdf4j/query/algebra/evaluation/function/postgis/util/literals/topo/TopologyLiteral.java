package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.topo;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.locationtech.jts.geom.Geometry;

public abstract class TopologyLiteral implements LiteralType {

	public abstract String unparse(Topology topo);
	
	public abstract Topology read(String literalValue);

}
