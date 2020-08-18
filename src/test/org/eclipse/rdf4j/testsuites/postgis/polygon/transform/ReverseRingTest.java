package org.eclipse.rdf4j.testsuites.postgis.polygon.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.transform.ReverseRing;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class ReverseRingTest {

	public static final String duplicateRings="POLYGON((8 2, 11 13, 2 6, 8 2),(8 2, 2 6, 11 13, 8 2))";
	
	public static final String nonduplicateRings="POLYGON ((8 2, 11 13, 2 6, 8 2),(8 2, 11 13, 2 6, 8 2))";
	
	@Test
	public void testReverseRing() {
		ReverseRing instance=new ReverseRing();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(duplicateRings, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(nonduplicateRings, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
