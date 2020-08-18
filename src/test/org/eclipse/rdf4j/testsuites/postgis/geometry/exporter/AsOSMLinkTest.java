package org.eclipse.rdf4j.testsuites.postgis.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsOSMLink;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class AsOSMLinkTest {

public static final String testGeometry="POINT(49.9928617 8.2472526)";
	
	@Test
	public void testAsOSMLink() {
		AsOSMLink instance=new AsOSMLink();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("http://www.openstreetmap.org/?minlon=8.2472526&minlat=49.9928617&maxlon=8.2472526&maxlat=49.9928617&mlat=49.9928617&mlon=8.2472526");
		assertEquals(expResult, result);
	}
	
}
