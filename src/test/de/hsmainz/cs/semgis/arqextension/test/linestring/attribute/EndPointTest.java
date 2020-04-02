package de.hsmainz.cs.semgis.arqextension.test.linestring.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.attribute.EndPoint;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class EndPointTest {

public static final String LineString2D="LINESTRING(1 1, 2 2, 3 3)";
	
	public static final String point="POINT (1 1)";
	
	public static final String LineString3D="LINESTRING(1 1 2, 1 2 3, 0 0 5)";
	
	@Test
	public void testLineString2D() {
		EndPoint instance=new EndPoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(LineString2D, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POINT (3 3)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

	@Test
	public void testLineString3D() {
		EndPoint instance=new EndPoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(LineString3D, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POINT (0 0 5)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

	@Test
	public void testPoint() {
		EndPoint instance=new EndPoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(point, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(point, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
