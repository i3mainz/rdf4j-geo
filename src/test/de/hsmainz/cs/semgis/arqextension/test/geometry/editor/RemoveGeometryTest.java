package de.hsmainz.cs.semgis.arqextension.test.geometry.editor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.editor.RemoveGeometry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class RemoveGeometryTest {

	public static final String lineString="GEOMETRYCOLLECTION(LINESTRING(0 0 1, 1 1 1, 1 2 3),POINT(1 2 3))";
	
	public static final String point="POINT(1 2 3)";
	
	@Test
	public void testRemoveGeometry1() {
		RemoveGeometry instance=new RemoveGeometry();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineString, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac,geo,valfac.createLiteral(1));
		Value expResult=valfac.createLiteral("GEOMETRYCOLLECTION (LINESTRING (0 0, 1 1, 1 2))", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

	@Test
	public void testRemoveGeometry1Z() {
		RemoveGeometry instance=new RemoveGeometry();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineString, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac,geo,valfac.createLiteral(1));
		Value expResult=valfac.createLiteral("GEOMETRYCOLLECTION (LINESTRING (0 0 1, 1 1 1, 1 2 3))", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testRemoveGeometry2() {
		RemoveGeometry instance=new RemoveGeometry();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineString, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac,geo,valfac.createLiteral(0));
		Value expResult=valfac.createLiteral("GEOMETRYCOLLECTION (POINT (1 2))", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

	@Test
	public void testRemoveGeometry2Z() {
		RemoveGeometry instance=new RemoveGeometry();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineString, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac,geo,valfac.createLiteral(0));
		Value expResult=valfac.createLiteral("GEOMETRYCOLLECTION (POINT (1 2 3))", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
