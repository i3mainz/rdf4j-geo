/*******************************************************************************
 * Copyright (c) 2015 Eclipse RDF4J contributors, Aduna, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package org.eclipse.rdf4j.query.algebra;

import org.eclipse.rdf4j.query.algebra.Add;
import org.eclipse.rdf4j.query.algebra.And;
import org.eclipse.rdf4j.query.algebra.ArbitraryLengthPath;
import org.eclipse.rdf4j.query.algebra.Avg;
import org.eclipse.rdf4j.query.algebra.BNodeGenerator;
import org.eclipse.rdf4j.query.algebra.BindingSetAssignment;
import org.eclipse.rdf4j.query.algebra.Bound;
import org.eclipse.rdf4j.query.algebra.Clear;
import org.eclipse.rdf4j.query.algebra.Coalesce;
import org.eclipse.rdf4j.query.algebra.Compare;
import org.eclipse.rdf4j.query.algebra.CompareAll;
import org.eclipse.rdf4j.query.algebra.CompareAny;
import org.eclipse.rdf4j.query.algebra.Copy;
import org.eclipse.rdf4j.query.algebra.Count;
import org.eclipse.rdf4j.query.algebra.Create;
import org.eclipse.rdf4j.query.algebra.Datatype;
import org.eclipse.rdf4j.query.algebra.DeleteData;
import org.eclipse.rdf4j.query.algebra.DescribeOperator;
import org.eclipse.rdf4j.query.algebra.Difference;
import org.eclipse.rdf4j.query.algebra.Distinct;
import org.eclipse.rdf4j.query.algebra.EmptySet;
import org.eclipse.rdf4j.query.algebra.Exists;
import org.eclipse.rdf4j.query.algebra.Extension;
import org.eclipse.rdf4j.query.algebra.ExtensionElem;
import org.eclipse.rdf4j.query.algebra.Filter;
import org.eclipse.rdf4j.query.algebra.FunctionCall;
import org.eclipse.rdf4j.query.algebra.Group;
import org.eclipse.rdf4j.query.algebra.GroupConcat;
import org.eclipse.rdf4j.query.algebra.GroupElem;
import org.eclipse.rdf4j.query.algebra.IRIFunction;
import org.eclipse.rdf4j.query.algebra.If;
import org.eclipse.rdf4j.query.algebra.In;
import org.eclipse.rdf4j.query.algebra.InsertData;
import org.eclipse.rdf4j.query.algebra.Intersection;
import org.eclipse.rdf4j.query.algebra.IsBNode;
import org.eclipse.rdf4j.query.algebra.IsLiteral;
import org.eclipse.rdf4j.query.algebra.IsNumeric;
import org.eclipse.rdf4j.query.algebra.IsResource;
import org.eclipse.rdf4j.query.algebra.IsURI;
import org.eclipse.rdf4j.query.algebra.Join;
import org.eclipse.rdf4j.query.algebra.Label;
import org.eclipse.rdf4j.query.algebra.Lang;
import org.eclipse.rdf4j.query.algebra.LangMatches;
import org.eclipse.rdf4j.query.algebra.LeftJoin;
import org.eclipse.rdf4j.query.algebra.Like;
import org.eclipse.rdf4j.query.algebra.ListMemberOperator;
import org.eclipse.rdf4j.query.algebra.Load;
import org.eclipse.rdf4j.query.algebra.LocalName;
import org.eclipse.rdf4j.query.algebra.MathExpr;
import org.eclipse.rdf4j.query.algebra.Max;
import org.eclipse.rdf4j.query.algebra.Min;
import org.eclipse.rdf4j.query.algebra.Modify;
import org.eclipse.rdf4j.query.algebra.Move;
import org.eclipse.rdf4j.query.algebra.MultiProjection;
import org.eclipse.rdf4j.query.algebra.Namespace;
import org.eclipse.rdf4j.query.algebra.Not;
import org.eclipse.rdf4j.query.algebra.Or;
import org.eclipse.rdf4j.query.algebra.Order;
import org.eclipse.rdf4j.query.algebra.OrderElem;
import org.eclipse.rdf4j.query.algebra.Projection;
import org.eclipse.rdf4j.query.algebra.ProjectionElem;
import org.eclipse.rdf4j.query.algebra.ProjectionElemList;
import org.eclipse.rdf4j.query.algebra.QueryModelNode;
import org.eclipse.rdf4j.query.algebra.QueryModelVisitor;
import org.eclipse.rdf4j.query.algebra.QueryRoot;
import org.eclipse.rdf4j.query.algebra.Reduced;
import org.eclipse.rdf4j.query.algebra.Regex;
import org.eclipse.rdf4j.query.algebra.SameTerm;
import org.eclipse.rdf4j.query.algebra.Sample;
import org.eclipse.rdf4j.query.algebra.Service;
import org.eclipse.rdf4j.query.algebra.SingletonSet;
import org.eclipse.rdf4j.query.algebra.Slice;
import org.eclipse.rdf4j.query.algebra.StatementPattern;
import org.eclipse.rdf4j.query.algebra.Str;
import org.eclipse.rdf4j.query.algebra.Sum;
import org.eclipse.rdf4j.query.algebra.Union;
import org.eclipse.rdf4j.query.algebra.ValueConstant;
import org.eclipse.rdf4j.query.algebra.Var;
import org.eclipse.rdf4j.query.algebra.ZeroLengthPath;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.AggCentroid;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.AvgX;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.AvgY;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.AvgZ;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.BoundingBox;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.MaxX;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.MaxY;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.MaxZ;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.MinX;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.MinY;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.aggregate.MinZ;

/**
 * An interface for query model visitors, implementing the Visitor pattern. Core query model nodes will call their
 * type-specific method when {@link QueryModelNode#visit(QueryModelVisitor)} is called. The method
 * {@link #meetOther(QueryModelNode)} is provided as a hook for foreign query model nodes.
 */
public interface QueryModelVisitor<X extends Exception> {

	public void meet(QueryRoot node) throws X;

	public void meet(Add add) throws X;

	public void meet(And node) throws X;

	public void meet(ArbitraryLengthPath node) throws X;

	public void meet(Avg node) throws X;
	
	public void meet(AvgX node) throws X;
	
	public void meet(AvgY node) throws X;
	
	public void meet(AvgZ node) throws X;

	public void meet(BindingSetAssignment node) throws X;

	public void meet(BNodeGenerator node) throws X;

	public void meet(Bound node) throws X;
	
	public void meet(BoundingBox node) throws X;

	public void meet(Clear clear) throws X;

	public void meet(Coalesce node) throws X;

	public void meet(Compare node) throws X;

	public void meet(CompareAll node) throws X;

	public void meet(CompareAny node) throws X;

	public void meet(DescribeOperator node) throws X;

	public void meet(Copy copy) throws X;

	public void meet(Count node) throws X;

	public void meet(Create create) throws X;

	public void meet(Datatype node) throws X;

	public void meet(DeleteData deleteData) throws X;

	public void meet(Difference node) throws X;

	public void meet(Distinct node) throws X;

	public void meet(EmptySet node) throws X;

	public void meet(Exists node) throws X;

	public void meet(Extension node) throws X;

	public void meet(ExtensionElem node) throws X;

	public void meet(Filter node) throws X;

	public void meet(FunctionCall node) throws X;

	public void meet(Group node) throws X;

	public void meet(GroupConcat node) throws X;

	public void meet(GroupElem node) throws X;

	public void meet(If node) throws X;

	public void meet(In node) throws X;

	public void meet(InsertData insertData) throws X;

	public void meet(Intersection node) throws X;

	public void meet(IRIFunction node) throws X;

	public void meet(IsBNode node) throws X;

	public void meet(IsLiteral node) throws X;

	public void meet(IsNumeric node) throws X;

	public void meet(IsResource node) throws X;

	public void meet(IsURI node) throws X;

	public void meet(Join node) throws X;

	public void meet(Label node) throws X;

	public void meet(Lang node) throws X;

	public void meet(LangMatches node) throws X;

	public void meet(LeftJoin node) throws X;

	public void meet(Like node) throws X;

	public void meet(Load load) throws X;

	public void meet(LocalName node) throws X;

	public void meet(MathExpr node) throws X;

	public void meet(Max node) throws X;
	
	public void meet(MaxX node) throws X;
	
	public void meet(MaxY node) throws X;
	
	public void meet(MaxZ node) throws X;

	public void meet(Min node) throws X;
	
	public void meet(MinX node) throws X;
	
	public void meet(MinY node) throws X;
	
	public void meet(MinZ node) throws X;

	public void meet(Modify modify) throws X;

	public void meet(Move move) throws X;

	public void meet(MultiProjection node) throws X;

	public void meet(Namespace node) throws X;

	public void meet(Not node) throws X;

	public void meet(Or node) throws X;

	public void meet(Order node) throws X;

	public void meet(OrderElem node) throws X;

	public void meet(Projection node) throws X;

	public void meet(ProjectionElem node) throws X;

	public void meet(ProjectionElemList node) throws X;

	public void meet(Reduced node) throws X;

	public void meet(Regex node) throws X;

	public void meet(SameTerm node) throws X;

	public void meet(Sample node) throws X;

	public void meet(Service node) throws X;

	public void meet(SingletonSet node) throws X;

	public void meet(Slice node) throws X;

	public void meet(StatementPattern node) throws X;

	public void meet(Str node) throws X;

	public void meet(Sum node) throws X;

	public void meet(Union node) throws X;

	public void meet(ValueConstant node) throws X;

	/**
	 */
	public void meet(ListMemberOperator node) throws X;

	public void meet(Var node) throws X;

	public void meet(ZeroLengthPath node) throws X;

	public void meetOther(QueryModelNode node) throws X;

	public void meet(AggCentroid aggCentroid);
}
