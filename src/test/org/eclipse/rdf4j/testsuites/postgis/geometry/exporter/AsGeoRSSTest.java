package org.eclipse.rdf4j.testsuites.postgis.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsGeoRSS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class AsGeoRSSTest {

	public static final String testGeometry="POINT(49.9928617 8.2472526)";
	
	@Test
	public void testAsGeoURI() {
		AsGeoRSS instance=new AsGeoRSS();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("geo:49.9928617,8.2472526;crs=EPSG:0");
	    assertEquals(expResult, result);
	}
	
}
