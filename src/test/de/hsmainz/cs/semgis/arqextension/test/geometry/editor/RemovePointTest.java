package de.hsmainz.cs.semgis.arqextension.test.geometry.editor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.editor.RemovePoint;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class RemovePointTest {

public static final String lineString="LINESTRING Z(0 0 1, 1 1 1,2 2 1)";
	
	@Test
	public void testRemovePoint() {
		RemovePoint instance=new RemovePoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(lineString, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,valfac.createLiteral(1));
		Value expResult=valfac.createLiteral("LINESTRING Z (0 0 1, 2 2 3)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
