package org.eclipse.rdf4j.testsuites.postgis.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsGeoJSON;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class AsGeoJSONTest {

public static final String testGeometry="LINESTRING(1 2 3, 4 5 6)";
	
	@Test
	public void testAsGeoJSON() {
		AsGeoJSON instance=new AsGeoJSON();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("{\"type\":\"LineString\",\"coordinates\":[[1.0,2.0,3.0],[4.0,5.0,6.0]]}");
	    assertEquals(expResult, result);
	}
	
}
