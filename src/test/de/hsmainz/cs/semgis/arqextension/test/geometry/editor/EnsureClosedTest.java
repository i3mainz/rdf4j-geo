package de.hsmainz.cs.semgis.arqextension.test.geometry.editor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.editor.EnsureClosed;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class EnsureClosedTest {

	public static final String duplicateRings="POLYGON((8 2, 11 13, 2 6, 8 2), (8 2, 11 13, 2 6, 8 2))";
	
	public static final String nonClosed="LINESTRING(8 2, 11 13, 2 6)";
	
	public static final String closed="LINESTRING(8 2, 11 13, 2 6, 8 2)";
	
	public static final String ring="LINEARRING (8 2, 11 13, 2 6, 8 2)";
	
	@Test
	public void testEnsureClosed() {
        EnsureClosed instance=new EnsureClosed();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(nonClosed, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(closed, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testEnsureClosed2() {
        EnsureClosed instance=new EnsureClosed();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(closed, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(closed, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
