package org.eclipse.rdf4j.testsuites.postgis.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.MinimumBoundingCircleCenter;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.Test;


public class MinimumDiameterLineTest {

	public static final String testPolygon="POLYGON ((0 0, 1 0, 1 1, 0.5 3.2e-4, 0 0))";
	
	public static final String result="LINESTRING ((0.5 0.5, 1 0))";
	
	@Test
	public void testMinimumDiameterLine() {
		MinimumBoundingCircleCenter instance=new MinimumBoundingCircleCenter();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value resultt=instance.evaluate(valfac,geo);
		Value expResult=valfac.createLiteral(result, WKTDatatype.LiteralIRI);
		assertEquals(expResult, resultt);
	}
	
}
