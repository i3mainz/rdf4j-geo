package org.eclipse.rdf4j.testsuites.postgis.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.Densify;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class DensifyTest {

public static final String isocelesTriangle="POLYGON((8 2, 11 13, 2 6, 8 2))";
	
	public static final String densified="POLYGON ((8 2, 7.25 2.5, 6.5 3, 5.75 3.5, 5 4, 4.25 4.5, 3.5 5, 2.75 5.5, 2 6, 2.75 6.583333333333333, 3.500000000000001 7.166666666666667, 4.25 7.75, 5 8.333333333333334, 5.75 8.916666666666666, 6.5 9.5, 7.25 10.083333333333334, 8 10.666666666666668, 8.75 11.25, 9.5 11.833333333333334, 10.25 12.416666666666666, 11 13, 10.75 12.083333333333334, 10.5 11.166666666666666, 10.25 10.25, 10 9.333333333333332, 9.75 8.416666666666668, 9.5 7.5, 9.25 6.583333333333333, 9 5.666666666666666, 8.75 4.75, 8.5 3.833333333333333, 8.25 2.9166666666666665, 8 2))";
	
	@Test
	public void testDensify() {
		Densify instance=new Densify();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(isocelesTriangle, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,valfac.createLiteral(1.));
		Value expResult=valfac.createLiteral(densified,WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
