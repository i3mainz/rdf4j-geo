package de.hsmainz.cs.semgis.arqextension.test.envelope.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.relation.BBOXRightOf;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class BBOXRightOfTest {

	public static final String testGeom1="LINESTRING (2 3, 5 6)";
	
	public static final String testGeom2="LINESTRING (1 4, 1 7)";
	
	public static final String testGeom3="LINESTRING (6 1, 6 5)";
	
	public static final String testGeom4="LINESTRING (0 0, 4 3)";
	
	
	@Test
	public void testBBOXRightOf() {
		BBOXRightOf instance=new BBOXRightOf();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom1, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}

	@Test
	public void testBBOXRightOf1() {
		BBOXRightOf instance=new BBOXRightOf();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom1, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
}
