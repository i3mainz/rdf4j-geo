package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.FlipCoordinates;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class FlipCoordinatesTest {

	public static final String testPolygon="POLYGON((0 0 2,0 5 2,5 0 2,0 0 2))";
	
	public static final String result="POLYGON ((0 0, 0 5, 5 0, 0 0))";
	
	@Test
	public void testFlipCoordinates() {
		FlipCoordinates instance=new FlipCoordinates();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value resultt=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(result, WKTDatatype.LiteralIRI);
		assertEquals(expResult, resultt);
	}
	
}
