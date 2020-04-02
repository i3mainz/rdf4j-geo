package de.hsmainz.cs.semgis.arqextension.test.polygon.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute.IsIsocelesTriangle;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class IsIsocelesTriangleTest {

	public static final String isocelesTriangle="POLYGON((8 2, 11 13, 2 6, 8 2))";
	
	public static final String notIsocelesTriangle="POLYGON((1 2, 3 4, 5 6, 1 2))";
	
	@Test
	public void testIsIsocelesTriangleTrue() {
		IsIsocelesTriangle instance=new IsIsocelesTriangle();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(isocelesTriangle, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testIsIsocelesTriangleFalse() {
		IsIsocelesTriangle instance=new IsIsocelesTriangle();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(notIsocelesTriangle, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
}
