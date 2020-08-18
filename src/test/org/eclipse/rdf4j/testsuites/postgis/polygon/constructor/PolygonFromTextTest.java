package org.eclipse.rdf4j.testsuites.postgis.polygon.constructor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.constructor.PolygonFromText;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class PolygonFromTextTest {

	public static final String testPolygon="POLYGON((-71.1776585052917 42.3902909739571,-71.1776820268866 42.3903701743239,-71.1776063012595 42.3903825660754,-71.1775826583081 42.3903033653531,-71.1776585052917 42.3902909739571))";
	
	@Test
	public void testPolygonFromText() {
		PolygonFromText instance=new PolygonFromText();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
