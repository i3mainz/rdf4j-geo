package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate;

import org.eclipse.rdf4j.query.algebra.AbstractAggregateOperator;
import org.eclipse.rdf4j.query.algebra.QueryModelVisitor;
import org.eclipse.rdf4j.query.algebra.ValueExpr;

/**
 * Aggregate function to find the average z coordinate of a set of geometries.
 *
 */
public class AvgZ extends AbstractAggregateOperator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3629984495652496978L;

	public AvgZ(ValueExpr arg) {
		super(arg);
	}

	public AvgZ(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof AvgZ && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "AvgZ".hashCode();
	}

	@Override
	public AvgZ clone() {
		return (AvgZ) super.clone();
	}

}
