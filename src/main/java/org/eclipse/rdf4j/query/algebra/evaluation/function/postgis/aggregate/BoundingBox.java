package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate;

import org.eclipse.rdf4j.query.algebra.AbstractAggregateOperator;
import org.eclipse.rdf4j.query.algebra.QueryModelVisitor;
import org.eclipse.rdf4j.query.algebra.ValueExpr;

public class BoundingBox extends AbstractAggregateOperator {

	public BoundingBox(ValueExpr arg) {
		super(arg);
	}

	public BoundingBox(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof BoundingBox && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "BBOX".hashCode();
	}

	@Override
	public BoundingBox clone() {
		return (BoundingBox) super.clone();
	}
}
