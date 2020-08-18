package org.eclipse.rdf4j.testsuites.postgis.envelope.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.envelope.relation.BBOXDistance;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class BBOXDistanceTest {

	public static final String testGeom1="LINESTRING (1 4, 1 7)";
	
	public static final String testGeom2="LINESTRING (0 0, 4 2)";
	
	public static final String testGeom3="LINESTRING (6 1, 6 5)";
	
	public static final String testGeom4="LINESTRING (2 3, 5 6)";
	
	@Test
	public void testBBOXDistance() {
		BBOXDistance instance=new BBOXDistance();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom1, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(2);
		assertEquals(expResult, result);
	}
	
}
