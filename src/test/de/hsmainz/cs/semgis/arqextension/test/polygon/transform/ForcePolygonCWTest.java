package de.hsmainz.cs.semgis.arqextension.test.polygon.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.transform.ForcePolygonCW;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class ForcePolygonCWTest {

	public static final String testPolygon="POLYGON((1 2, 7 8, 5 6, 3 4, 1 2))";
	
	public static final String testPolygon2="POLYGON((1 2, 3 4, 5 6, 1 2))";
	
	@Test
	public void testForcePolygonCW() {
		ForcePolygonCW instance=new ForcePolygonCW();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
