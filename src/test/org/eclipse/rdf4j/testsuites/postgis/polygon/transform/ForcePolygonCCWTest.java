package org.eclipse.rdf4j.testsuites.postgis.polygon.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.transform.ForcePolygonCCW;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class ForcePolygonCCWTest {

	public static final String testPolygon="POLYGON ((1 2, 7 8, 5 6, 3 4, 1 2))";
	
	public static final String testPolygon2="POLYGON ((1 2, 3 4, 5 6, 7 8, 1 2))";
	
	@Test
	public void testForcePolygonCCW() {
		ForcePolygonCCW instance=new ForcePolygonCCW();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(testPolygon2, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
	
}
