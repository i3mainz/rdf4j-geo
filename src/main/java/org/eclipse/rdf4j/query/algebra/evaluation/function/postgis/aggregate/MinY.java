package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate;

import org.eclipse.rdf4j.query.algebra.AbstractAggregateOperator;
import org.eclipse.rdf4j.query.algebra.QueryModelVisitor;
import org.eclipse.rdf4j.query.algebra.ValueExpr;


/**
 * Aggregate function to find the minimum y coordinate of a set of geometries.
 *
 */
public class MinY extends AbstractAggregateOperator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5941565197575871003L;

	public MinY(ValueExpr arg) {
		super(arg);
	}

	public MinY(ValueExpr arg, boolean distinct) {
		super(arg, distinct);
	}

	@Override
	public <X extends Exception> void visit(QueryModelVisitor<X> visitor) throws X {
		visitor.meet(this);
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof MinY && super.equals(other);
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ "MinY".hashCode();
	}

	@Override
	public MinY clone() {
		return (MinY) super.clone();
	}

}
