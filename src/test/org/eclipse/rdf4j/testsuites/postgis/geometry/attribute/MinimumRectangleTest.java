package org.eclipse.rdf4j.testsuites.postgis.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.MinimumRectangle;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class MinimumRectangleTest {

	public static final String testPolygon="POLYGON ((0 0, 1 0, 1 1, 0.5 3.2e-4, 0 0))";
	
	@Test
	public void testMinimumRectangle() {
		MinimumRectangle instance=new MinimumRectangle();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POLYGON ((0 0, 0.5 -0.5, 1.5 0.5, 1 1, 0 0))",WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
