package org.eclipse.rdf4j.testsuites.postgis.envelope.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.relation.BBOXOverlapsLeft;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class BBOXOverlapsLeftTest {

	public static final String testGeom1="POLYGON ((0 0,2 3, 5 0, 0 0))";
	
	public static final String testGeom2="POLYGON ((2 1,2 3, 7 0, 2 1))";
	
	public static final String testGeom3="POLYGON ((-2 1,2 3, 7 9, -2 1))";
	
	public static final String testGeom4="LINESTRING (0 0, 4 3)";
	
	
	@Test
	public void testBBOXLeftOfTrue() {
		BBOXOverlapsLeft instance=new BBOXOverlapsLeft();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom1, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testBBOXLeftOfFalse() {
		BBOXOverlapsLeft instance=new BBOXOverlapsLeft();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom3, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
}
