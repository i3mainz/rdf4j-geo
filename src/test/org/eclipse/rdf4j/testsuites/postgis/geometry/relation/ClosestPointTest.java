package org.eclipse.rdf4j.testsuites.postgis.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.ClosestPoint;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class ClosestPointTest {

	public static final String testPoint="POINT (100 100)";
	
	public static final String testLineString="LINESTRING (20 80, 98 190, 110 180, 50 75 )";
	
	@Test
	public void testClosestPoint() {		
		ClosestPoint instance=new ClosestPoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPoint, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testLineString, WKTDatatype.LiteralIRI);
		Value expResult=valfac.createLiteral(testPoint, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		assertEquals(expResult, result);
	}
	
}
