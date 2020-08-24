package org.eclipse.rdf4j.testsuites.postgis.polygon.editor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.editor.AddInteriorRing;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class AddRingTest {

	public static final String duplicateRings="POLYGON ((8 2, 11 13, 2 6, 8 2), (8 2, 11 13, 2 6, 8 2))";
	
	public static final String nonduplicateRings="POLYGON ((8 2, 11 13, 2 6, 8 2))";
	
	public static final String ring="LINEARRING (8 2, 11 13, 2 6, 8 2)";
	
	@Test
	public void testAddRing() {
		AddInteriorRing instance=new AddInteriorRing();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(nonduplicateRings, WKTDatatype.LiteralIRI);
		Value georing=valfac.createLiteral(ring, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,georing);
		Value expResult=valfac.createLiteral(duplicateRings, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
