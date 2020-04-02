package de.hsmainz.cs.semgis.arqextension.test.linestring.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.attribute.StartPoint;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class StartPointTest {

public static final String LineString2D="LINESTRING(0 1, 0 2)";
	
	public static final String point="POINT(0 1)";
	
	public static final String LineString3D="LINESTRING(0 1 1, 0 2 2)";
	
	public static final String CircularString="CIRCULARSTRING(5 2,-3 1.999999, -2 1, -4 2, 5 2)";
	
	@Test
	public void testLineString2D() {
		StartPoint instance=new StartPoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(LineString2D, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POINT (0 1)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

	@Test
	public void testLineString3D() {
		StartPoint instance=new StartPoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(LineString3D, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POINT Z (0 1 1)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

	@Test
	public void testCircularString() {
		StartPoint instance=new StartPoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(CircularString, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POINT (5 2)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testPoint() {
		StartPoint instance=new StartPoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(point, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POINT (0 1)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
