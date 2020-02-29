package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate;

import org.eclipse.rdf4j.query.algebra.AbstractAggregateOperator;
import org.eclipse.rdf4j.query.algebra.QueryModelVisitor;
import org.eclipse.rdf4j.query.algebra.ValueExpr;


/**
 * Aggregate function to find the maximum y coordinate of a set of geometries.
 *
 */
public class MaxY extends AbstractAggregateOperator {

	public MaxY(ValueExpr arg) {
		super(arg);
	}

	public MaxY(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MaxY && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "MaxY".hashCode();
	}

	@Override
	public MaxY clone() {
		return (MaxY) super.clone();
	}

}
