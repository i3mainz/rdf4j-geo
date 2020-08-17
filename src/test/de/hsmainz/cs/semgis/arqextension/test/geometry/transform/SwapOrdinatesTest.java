package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.SwapOrdinates;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class SwapOrdinatesTest {

	public static final String testPolygon="POLYGON((0 0 2,0 5 2,5 0 2,0 0 2))";
	
	public static final String res="POLYGON ((0 0, 5 0, 0 5, 0 0))";
	
	@Test
	public void testSwapOrdinates() {	
		SwapOrdinates instance=new SwapOrdinates();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,valfac.createLiteral("xy"));
		Value expResult=valfac.createLiteral(res, WKTDatatype.LiteralIRI);
	    assertEquals(expResult, result);
	}
	
}
