package org.eclipse.rdf4j.testsuites.postgis.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.ShiftLongitude;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class ShiftLongitudeTest {

	public static final String testPolygon="POLYGON((-340 0 2,0 5 2,5 0 2,-340 0 2))";
	
	public static final String result="POLYGON ((20 0, 0 5, 5 0, 20 0))";
	
	@Test
	public void testShiftLongitude() {
		ShiftLongitude instance=new ShiftLongitude();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value resultt=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(result, WKTDatatype.LiteralIRI);
		assertEquals(expResult, resultt);
	}
	
}
