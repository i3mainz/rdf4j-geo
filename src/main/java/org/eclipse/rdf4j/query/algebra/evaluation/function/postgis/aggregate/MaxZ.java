package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate;

import org.eclipse.rdf4j.query.algebra.AbstractAggregateOperator;
import org.eclipse.rdf4j.query.algebra.QueryModelVisitor;
import org.eclipse.rdf4j.query.algebra.ValueExpr;


/**
 * Aggregate function to find the maximum z coordinate of a set of geometries.
 *
 */
public class MaxZ extends AbstractAggregateOperator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7564400908836828357L;

	public MaxZ(ValueExpr arg) {
		super(arg);
	}

	public MaxZ(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MaxZ && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "MaxZ".hashCode();
	}

	@Override
	public MaxZ clone() {
		return (MaxZ) super.clone();
	}

}
