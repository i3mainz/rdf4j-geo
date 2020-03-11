package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate;

import org.eclipse.rdf4j.query.algebra.AbstractAggregateOperator;
import org.eclipse.rdf4j.query.algebra.QueryModelVisitor;
import org.eclipse.rdf4j.query.algebra.ValueExpr;


/**
 * Aggregate function to find the minimum x coordinate of a set of geometries.
 *
 */
public class MinX extends AbstractAggregateOperator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6043992669883130664L;

	public MinX(ValueExpr arg) {
		super(arg);
	}

	public MinX(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MinX && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "MinX".hashCode();
	}

	@Override
	public MinX clone() {
		return (MinX) super.clone();
	}
}