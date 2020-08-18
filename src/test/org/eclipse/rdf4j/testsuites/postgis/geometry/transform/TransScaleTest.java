package org.eclipse.rdf4j.testsuites.postgis.geometry.transform;

import static org.junit.Assert.assertEquals;


import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.TransScale;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class TransScaleTest {

public static final String testLineString="LINESTRING(1 2,1 10)";

public static final String res="LINESTRING (3 5, 3 20)";
	
	@Test
	public void testTransScale() {
        TransScale instance=new TransScale();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testLineString, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,valfac.createLiteral(2),valfac.createLiteral(2),valfac.createLiteral(2),valfac.createLiteral(2));
		Value expResult=valfac.createLiteral(res, WKTDatatype.LiteralIRI);
	    assertEquals(expResult, result);
	}
	
}
