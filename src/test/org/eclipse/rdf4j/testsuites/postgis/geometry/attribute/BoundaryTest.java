package org.eclipse.rdf4j.testsuites.postgis.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.Boundary;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class BoundaryTest {

	public static final String testPolygon="POLYGON ((0 0, 1 0, 1 1, 0.5 3.2e-4, 0 0))";
	
	public static final String result="LINEARRING (0 0, 1 0, 1 1, 0.5 0.00032, 0 0)";
	
	@Test
	public void testBoundary() {
		Boundary instance=new Boundary();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value resultt=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(result,WKTDatatype.LiteralIRI);
		assertEquals(expResult, resultt);
	}
	
}
