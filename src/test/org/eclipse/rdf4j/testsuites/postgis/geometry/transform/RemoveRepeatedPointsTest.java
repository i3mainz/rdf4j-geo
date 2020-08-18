package org.eclipse.rdf4j.testsuites.postgis.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.editor.RemoveRepeatedPoints;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class RemoveRepeatedPointsTest {

	public static final String testGeometry="LINESTRING (0 0, 0 1, 1 1, 1 0, 0 0)";
	
	public static final String testGeometry2="LINESTRING (0 1, 1 1, 1 0)";

	@Test
	public void testRemoveRepeatedPoints() {
		RemoveRepeatedPoints instance=new RemoveRepeatedPoints();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,valfac.createLiteral(0.));
		Value expResult=valfac.createLiteral(testGeometry2,WKTDatatype.LiteralIRI);
	    assertEquals(expResult, result);
	}
}
