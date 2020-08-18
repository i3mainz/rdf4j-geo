package org.eclipse.rdf4j.testsuites.postgis.polygon.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute.IsPolygonCW;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class IsPolygonCWTest {

	public static final String testPolygon="POLYGON((1 2, 7 8, 5 6, 3 4, 1 2))";
	
	public static final String testPolygon2="POLYGON((1 2, 3 4, 5 6, 1 2))";
	
	@Test
	public void testIsPolygonCWTrue() {
		IsPolygonCW instance=new IsPolygonCW();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testIsPolygonCWFalse() {
		IsPolygonCW instance=new IsPolygonCW();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
}
