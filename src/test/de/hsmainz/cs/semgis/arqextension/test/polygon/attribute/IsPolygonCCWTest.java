package de.hsmainz.cs.semgis.arqextension.test.polygon.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute.IsPolygonCCW;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class IsPolygonCCWTest {

	public static final String testPolygon="POLYGON((1 2, 7 8, 5 6, 3 4, 1 2))";
	
	public static final String testPolygon2="POLYGON((1 2, 3 4, 5 6, 1 2))";
	
	@Test
	public void testIsPolygonCCWTrue() {
		IsPolygonCCW instance=new IsPolygonCCW();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testIsPolygonCCWFalse() {
		IsPolygonCCW instance=new IsPolygonCCW();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}
	
}
