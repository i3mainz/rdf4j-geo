package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate;

import org.eclipse.rdf4j.query.algebra.AbstractAggregateOperator;
import org.eclipse.rdf4j.query.algebra.QueryModelVisitor;
import org.eclipse.rdf4j.query.algebra.ValueExpr;

/**
 * Aggregate function to find the average y coordinate of a set of geometries.
 *
 */
public class AvgY extends AbstractAggregateOperator {

	public AvgY(ValueExpr arg) {
		super(arg);
	}

	public AvgY(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof AvgY && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "AvgY".hashCode();
	}

	@Override
	public AvgY clone() {
		return (AvgY) super.clone();
	}

}
