package de.hsmainz.cs.semgis.arqextension.test.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.exporter.AsHexWKB;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class AsHexWKBTest {

	public static final String testGeometry="POLYGON((0 0,0 1,1 1,1 0,0 0))";
	
	@Test
	public void testAsEncodedPolyline() {
		AsHexWKB instance=new AsHexWKB();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("0103000020E6100000010000000500\n" + 
        		"00000000000000000000000000000000\n" + 
        		"00000000000000000000000000000000F03F\n" + 
        		"000000000000F03F000000000000F03F000000000000F03\n" + 
        		"F000000000000000000000000000000000000000000000000");
	    assertEquals(expResult, result);
	}
	
}
