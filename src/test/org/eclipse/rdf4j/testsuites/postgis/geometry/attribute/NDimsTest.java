package org.eclipse.rdf4j.testsuites.postgis.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.NDims;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class NDimsTest {

public static final String geom2D="POINT(1 1)";
	
	public static final String geom3D="POINT Z(1 1 2)";
	
	public static final String geomM="POINT M(1 1 0.5)";
	
	
	@Test
	public void test2DGeom() {
		NDims instance=new NDims();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(geom2D, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(2);
		assertEquals(expResult, result);
	}
	
	@Test
	public void test3DGeom() {
		NDims instance=new NDims();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(geom3D, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(3);
		assertEquals(expResult, result);
	}

	@Test
	public void testMGeom() {
		NDims instance=new NDims();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(geomM, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(2);
		assertEquals(expResult, result);
	}
	
}
