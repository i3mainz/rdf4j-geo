package de.hsmainz.cs.semgis.arqextension.test.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsText;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class AsTextTest {


	public static final String testGeometryZ="LINESTRING Z(1 2 3, 4 5 6)";
	
	public static final String testGeometry="LINESTRING (1 2, 4 5)";
	
	@Test
	public void testAsText() {
		AsText instance=new AsText();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("LINESTRING (1 2, 4 5)");
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testAsTextZ() {
		AsText instance=new AsText();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("LINESTRING (1 2 3, 4 5 6)");
	    assertEquals(expResult, result);
	}
	
}
