package org.eclipse.rdf4j.testsuites.postgis.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.Test;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsTWKB;

public class AsTWKBTest {

	public static final String testGeometry="POINT(49.9928617 8.2472526)";
	
	@Test
	public void testAsTWKB() {
		AsTWKB instance=new AsTWKB();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("�");
		assertEquals(expResult, result);
	}

	
}