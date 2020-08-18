package org.eclipse.rdf4j.testsuites.postgis.point.constructor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.constructor.MakePoint;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class MakePointTest {

	public static final String testPoint1="POINT(-71.1043443253471, 42.3150676015829)";
	
	public static final String testPointM="POINT M(1, 2,1.5)";
	
	@Test
	public void testMakePoint1() {
		MakePoint instance=new MakePoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPoint1, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(testPoint1, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testMakePointXYZ() {
		MakePoint instance=new MakePoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPointM, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(testPointM, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
