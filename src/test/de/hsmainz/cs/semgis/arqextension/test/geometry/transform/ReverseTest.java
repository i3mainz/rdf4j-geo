package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.Reverse;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class ReverseTest {

public static final String testLineString="LINESTRING(1 2,1 10)";
	
	@Test
	public void testReverse() {
		Reverse instance=new Reverse();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testLineString, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("LINESTRING (1 10, 1 2)",WKTDatatype.LiteralIRI);
	    assertEquals(expResult, result);
	}
}
