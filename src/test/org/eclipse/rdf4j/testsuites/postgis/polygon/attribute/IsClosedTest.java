package org.eclipse.rdf4j.testsuites.postgis.polygon.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.IsClosed;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class IsClosedTest {

public static final String notClosed="LINESTRING(0 0, 1 1)";
	
	public static final String isClosed="LINESTRING(0 0, 0 1, 1 1, 0 0)";
	
	public static final String mlNotClosed="MULTILINESTRING((0 0, 0 1, 1 1, 0 0),(0 0, 1 1))";
	
	public static final String pointClosed="POINT(0 0)";
	
	public static final String multiPointClosed="MULTIPOINT((0 0), (1 1))";
	
	
	@Test
	public void testLineStringNotClosed() {
		IsClosed instance=new IsClosed();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(notClosed, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}

	@Test
	public void testLineStringClosed() {
		IsClosed instance=new IsClosed();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(isClosed, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testMultiLineStringNotClosed() {
		IsClosed instance=new IsClosed();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(mlNotClosed, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}	

	@Test
	public void testpointClosed() {
		IsClosed instance=new IsClosed();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(pointClosed, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}	

	@Test
	public void testmultiPointClosed() {
		IsClosed instance=new IsClosed();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(multiPointClosed, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}	
	
}
