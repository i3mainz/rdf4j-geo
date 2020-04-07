package de.hsmainz.cs.semgis.arqextension.test.polygon.editor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.editor.SetInteriorRing;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class SetRingTest {

	public static final String duplicateRings="POLYGON((8 2, 11 13, 2 6, 8 2), (8 2, 11 13, 2 6, 8 2))";
	
	public static final String nonduplicateRings="POLYGON((8 2, 11 13, 2 6, 8 2))";
	
	public static final String ring="LINEARRING (8 2, 11 13, 2 7, 8 2)";
	
	@Test
	public void testSetRing() {
		SetInteriorRing instance=new SetInteriorRing();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(duplicateRings, WKTDatatype.LiteralIRI);
		Value ringg=valfac.createLiteral(ring, WKTDatatype.LiteralIRI);
		Value index=valfac.createLiteral(0);
		Value result=instance.evaluate(valfac, geo,index,ringg);
		Value expResult=valfac.createLiteral(nonduplicateRings, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
