package org.eclipse.rdf4j.testsuites.postgis.linestring.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.PointN;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class PointNTest {

public static final String lineString="LINESTRING(0 0, 1 1, 2 2)";
	
	public static final String circularLineString="CIRCULARSTRING(1 2, 3 2, 1 2)";
	
	public static final String lineString3D="LINESTRING(0 0 0, 1 1 1, 2 2 2)";
	
	@Test
	public void testLineString() {
		PointN instance=new PointN();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineString, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,valfac.createLiteral(2));
		Value expResult=valfac.createLiteral("POINT (2 2)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}	
	
}
