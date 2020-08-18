package org.eclipse.rdf4j.testsuites.postgis.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.Centroid;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class CentroidTest {

public static final String testGeometry="MULTIPOINT (( -1 0), (-1 2), (-1 3), (-1 4), (-1 7), (0 1), (0 3), (1 1), (2 0), (6 0), (7 8), (9 8), (10 6))";
	
	@Test
	public void testCentroid() {
        Centroid instance=new Centroid();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POINT (2.30769230769231 3.30769230769231)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
