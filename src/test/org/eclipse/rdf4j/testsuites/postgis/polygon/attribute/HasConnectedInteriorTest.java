package org.eclipse.rdf4j.testsuites.postgis.polygon.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute.HasConnectedInterior;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class HasConnectedInteriorTest {

	public static final String duplicateRings="POLYGON((8 2, 11 13, 2 6, 8 2),(8 2, 11 13, 2 6, 8 2))";
	
	public static final String nonduplicateRings="POLYGON((1 2, 3 4, 5 6, 1 2))";
	
	@Test
	public void testHasConnectedInteriorTrue() {
		HasConnectedInterior instance=new HasConnectedInterior();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(duplicateRings, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testHasConnectedInteriorFalse() {
		HasConnectedInterior instance=new HasConnectedInterior();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(nonduplicateRings, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
}
