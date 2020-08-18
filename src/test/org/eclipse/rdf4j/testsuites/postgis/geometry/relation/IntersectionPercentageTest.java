package org.eclipse.rdf4j.testsuites.postgis.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.IntersectionPercentage;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class IntersectionPercentageTest {

public static final String testGeom="LINESTRING(77.29 29.07,77.42 29.26,77.27 29.31,77.29 29.07)";
	
	public static final String testGeom2="LINESTRING(77.42 29.26 ,10 10)";
	
	public static final String result="POINT(5 5)";
	
	public static final String isocelesTriangle="POLYGON((1 2, 11 13, 5 6, 1 2))";
	
	public static final String notIsocelesTriangle="POLYGON((1 2, 11 13, 5 5, 1 2))";
	
	@Test
	public void testIntersectionPercentage() {
		IntersectionPercentage instance=new IntersectionPercentage();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(0.);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testIntersectionPercentage2() {
		IntersectionPercentage instance=new IntersectionPercentage();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(isocelesTriangle, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(notIsocelesTriangle, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(0.2857142857142857e0);
		assertEquals(expResult, result);
	}
	
}
