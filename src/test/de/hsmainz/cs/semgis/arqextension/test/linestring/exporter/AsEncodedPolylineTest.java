package de.hsmainz.cs.semgis.arqextension.test.linestring.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.exporter.AsEncodedPolyline;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class AsEncodedPolylineTest {

	public static final String testGeometry="LINESTRING(-120.2 38.5,-120.95 40.7,-126.453 43.252)";
	
	@Test
	public void testAsEncodedPolyline() {
		AsEncodedPolyline instance=new AsEncodedPolyline();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("|_p~iF~ps|U_ulLnnqC_mqNvxq`@");
		assertEquals(expResult, result);
	}
	
}
