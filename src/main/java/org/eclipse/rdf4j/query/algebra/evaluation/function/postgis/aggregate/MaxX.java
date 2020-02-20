package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate;

import org.eclipse.rdf4j.query.algebra.AbstractAggregateOperator;
import org.eclipse.rdf4j.query.algebra.QueryModelVisitor;
import org.eclipse.rdf4j.query.algebra.ValueExpr;

/**
 * @author David Huynh
 */
public class MaxX extends AbstractAggregateOperator {

	public MaxX(ValueExpr arg) {
		super(arg);
	}

	public MaxX(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MaxX && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "MaxX".hashCode();
	}

	@Override
	public MaxX clone() {
		return (MaxX) super.clone();
	}
}
