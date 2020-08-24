package org.eclipse.rdf4j.testsuites.postgis.polygon.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute.NumDistinctInteriorRings;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class NumDistinctInteriorRingsTest {

	public static final String testPolygon="POLYGON((1 2, 3 4, 5 6, 1 2))";
	
	@Test
	public void testNRings() {
		NumDistinctInteriorRings instance=new NumDistinctInteriorRings();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(0);
		assertEquals(expResult, result);
	}	
	
}
