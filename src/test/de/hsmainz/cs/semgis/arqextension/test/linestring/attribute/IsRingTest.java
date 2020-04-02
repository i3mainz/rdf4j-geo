package de.hsmainz.cs.semgis.arqextension.test.linestring.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.IsRing;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class IsRingTest {
	
	public static final String isRing="LINESTRING(0 0, 0 1, 1 1, 1 0, 0 0)";
	
	public static final String isNotRing="LINESTRING(0 0, 0 1, 1 0, 1 1, 0 0)";
	
	@Test
	public void testLineStringIsRing() {
		IsRing instance=new IsRing();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(isRing, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testLineStringIsNotRing() {
		IsRing instance=new IsRing();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(isNotRing, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
}
