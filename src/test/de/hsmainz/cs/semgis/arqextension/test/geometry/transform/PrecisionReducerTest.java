package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.PrecisionReducer;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class PrecisionReducerTest {

	public static final String testGeom="POINT (0.3424 0.3424)";

	public static final String resultGeom="POINT (0.34 0.34)";

		@Test
		public void testPrecisionReducer() {
			PrecisionReducer instance=new PrecisionReducer();
			ValueFactory valfac=SimpleValueFactory.getInstance();
			Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
			Value result=instance.evaluate(valfac, geo,valfac.createLiteral(2));
			Value expResult=valfac.createLiteral(resultGeom, WKTDatatype.LiteralIRI);
			assertEquals(expResult, result);
		}
	
}
