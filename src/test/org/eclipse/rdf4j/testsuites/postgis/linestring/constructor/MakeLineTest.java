package org.eclipse.rdf4j.testsuites.postgis.linestring.constructor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.constructor.MakeLine;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class MakeLineTest {

	public static final String testPoint1="POINT(-71.1043443253471, 42.3150676015829)";
	
	public static final String testPoint2="POINT(1., 2.)";
	
	public static final String testLine="LINESTRING (-71.1043443253471, 42.3150676015829, 1. 2.)";
	
	public static final String testPointM="POINT M(1, 2,1.5)";
	
	@Test
	public void testMakeLine1() {
		MakeLine instance=new MakeLine();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPoint1, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testPoint2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(testLine,WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
