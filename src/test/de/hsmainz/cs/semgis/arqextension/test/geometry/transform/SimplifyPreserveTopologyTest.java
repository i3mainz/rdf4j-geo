package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.SimplifyPreserveTopology;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class SimplifyPreserveTopologyTest {

	public static final String testGeom="LINESTRING(5 2, 3 8, 6 20, 7 25, 10 10)";
	
	@Test
	public void testSimplifyVW() {
		SimplifyPreserveTopology instance=new SimplifyPreserveTopology();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("LINESTRING (5 2, 7 25, 10 10)");
		assertEquals(expResult, result);
	}

}
