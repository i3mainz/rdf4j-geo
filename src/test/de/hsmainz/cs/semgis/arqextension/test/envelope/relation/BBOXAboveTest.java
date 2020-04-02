package de.hsmainz.cs.semgis.arqextension.test.envelope.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.relation.BBOXAbove;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class BBOXAboveTest {

	public static final String testGeom1="LINESTRING (1 4, 1 7)";
	
	public static final String testGeom2="LINESTRING (0 0, 4 2)";
	
	public static final String testGeom3="LINESTRING (6 1, 6 5)";
	
	public static final String testGeom4="LINESTRING (2 3, 5 6)";
	
	
	@Test
	public void testBBOXAbove() {
		BBOXAbove instance=new BBOXAbove();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom1, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testBBOXAbove1() {
		BBOXAbove instance=new BBOXAbove();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom1, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
}
