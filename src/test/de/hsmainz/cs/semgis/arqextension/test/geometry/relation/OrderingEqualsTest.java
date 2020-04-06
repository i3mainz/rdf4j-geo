package de.hsmainz.cs.semgis.arqextension.test.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.OrderingEquals;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class OrderingEqualsTest {

	public static final String lineStringSmall="LINESTRING(0 0, 10 10)";
	
	public static final String lineStringSmallReverse="LINESTRING(10 10, 0 0)";
	
	public static final String lineStringMedium="LINESTRING(0 0, 5 5, 10 10)";
	
	public static final String lineStringMedium2="LINESTRING(0 0, 0 0, 10 10)";
	
	@Test
	public void testOrderingEquals1() {
		OrderingEquals instance=new OrderingEquals();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineStringSmall, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(lineStringMedium, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}

	@Test
	public void testOrderingEquals2() {
		OrderingEquals instance=new OrderingEquals();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineStringSmall, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(lineStringMedium2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testOrderingEquals3() {
		OrderingEquals instance=new OrderingEquals();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineStringSmallReverse, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(lineStringMedium2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
}
