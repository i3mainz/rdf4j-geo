package de.hsmainz.cs.semgis.arqextension.test.geometry.editor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.editor.AddGeometry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class AddGeometryTest {

	public static final String lineString="GEOMETRYCOLLECTION(LINESTRING(0 0 1, 1 1 1))";
	
	public static final String point="POINT(1 2 3)";
	
	@Test
	public void testAddGeometry() {
		AddGeometry instance=new AddGeometry();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineString, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(point, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac,geo,geo2);
		Value expResult=valfac.createLiteral("GEOMETRYCOLLECTION(LINESTRING(0 0 1, 1 1 1, 1 2 3),POINT(1 2 3))", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
