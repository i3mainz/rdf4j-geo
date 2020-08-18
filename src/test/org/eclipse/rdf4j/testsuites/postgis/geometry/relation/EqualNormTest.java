package org.eclipse.rdf4j.testsuites.postgis.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.EqualsNorm;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class EqualNormTest {

	public static final String testGeom="LINESTRING(77.29 29.07,77.42 29.26,77.27 29.31,77.29 29.07)";
	
	public static final String testGeom2="LINESTRING(77.42 29.26 ,10 10)";
	
	public static final String result="POINT(5 5)";
	
	@Test
	public void testEqualNormFalse() {
		EqualsNorm instance=new EqualsNorm();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(false);
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testEqualNormTrue() {
		EqualsNorm instance=new EqualsNorm();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(true);
	    assertEquals(expResult, result);
	}
	
}
