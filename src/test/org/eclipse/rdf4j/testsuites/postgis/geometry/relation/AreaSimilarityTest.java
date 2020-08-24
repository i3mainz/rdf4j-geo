package org.eclipse.rdf4j.testsuites.postgis.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.AreaSimilarity;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class AreaSimilarityTest {

	public static final String isocelesTriangle="POLYGON((1 2, 11 13, 5 6, 1 2))";
	
	public static final String notIsocelesTriangle="POLYGON((1 2, 3 4, 5 6, 1 2))";
	
	@Test
	public void testAreaSimilarity() {
		AreaSimilarity instance=new AreaSimilarity();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(isocelesTriangle, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(notIsocelesTriangle, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(0.);
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testAreaSimilarity2() {
		AreaSimilarity instance=new AreaSimilarity();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(isocelesTriangle, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(isocelesTriangle, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(1.);
	    assertEquals(expResult, result);
	}
	
}
