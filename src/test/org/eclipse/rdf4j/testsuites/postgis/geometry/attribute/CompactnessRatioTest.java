package org.eclipse.rdf4j.testsuites.postgis.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.CompactnessRatio;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;

public class CompactnessRatioTest {

	public static final String testGeometry="POINT(0 0)";

	public static final String testPolygon="POLYGON((0 0 2,0 5 2,5 0 2,0 0 2))";
	
	@Test
	public void testCompactnessRatioNaN() throws ParseException {
		CompactnessRatio instance=new CompactnessRatio();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(Double.NaN);
		assertEquals(expResult, result);
	}

	@Test
	public void testCompactnessRatio() throws ParseException {
		CompactnessRatio instance=new CompactnessRatio();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(0.7341744237254845);
		assertEquals(expResult, result);
	}
	
}
