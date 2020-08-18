package org.eclipse.rdf4j.testsuites.postgis.point.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute.ZMin;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class MinZTest {

public static final String testPoint="LINESTRING(1 2 3, 4 5 6,7 8 9)";
	
	@Test
	public void testZMin() {
		ZMin instance=new ZMin();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPoint, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(3.);
		assertEquals(expResult, result);
	}
	
}
