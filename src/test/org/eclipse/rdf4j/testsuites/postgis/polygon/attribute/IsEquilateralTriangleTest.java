package org.eclipse.rdf4j.testsuites.postgis.polygon.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute.IsEquilateralTriangle;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class IsEquilateralTriangleTest {

	public static final String testPolygon="POLYGON((0 0, 56 15, 15 56, 0 0))";
	
	public static final String testPolygon2="POLYGON((1 2, 3 4, 5 6, 1 2))";
	
	@Test
	public void testIsEquilateralTriangleFalse() {
		IsEquilateralTriangle instance=new IsEquilateralTriangle();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testIsEquilateralTriangleTrue() {
		IsEquilateralTriangle instance=new IsEquilateralTriangle();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}
	
}
