package org.eclipse.rdf4j.testsuites.postgis.geometry.attribute;

import static org.junit.Assert.assertEquals;


import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.HasRepeatedPoints;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class HasRepeatedPointsTest {
	
	public static final String testGeometry="LINESTRING(0 0, 1 1, 2 4, 1 1,6 8)";

	public static final String testGeometry2="LINESTRING(0 0, 1 1, 2 4,6 8)";

		@Test
		public void testHasRepeatedPoints() {
			HasRepeatedPoints instance=new HasRepeatedPoints();
			ValueFactory valfac=SimpleValueFactory.getInstance();
			Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
			Value result=instance.evaluate(valfac, geo);
			Value expResult=valfac.createLiteral(true);
		    assertEquals(expResult, result);
		}

		@Test
		public void testHasRepeatedPoints2() {
			HasRepeatedPoints instance=new HasRepeatedPoints();
			ValueFactory valfac=SimpleValueFactory.getInstance();
			Value geo=valfac.createLiteral(testGeometry2, WKTDatatype.LiteralIRI);
			Value result=instance.evaluate(valfac, geo);
			Value expResult=valfac.createLiteral(false);
		    assertEquals(expResult, result);
		}

}
