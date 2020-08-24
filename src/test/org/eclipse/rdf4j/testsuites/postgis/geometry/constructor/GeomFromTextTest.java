package org.eclipse.rdf4j.testsuites.postgis.geometry.constructor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.constructor.GeomFromText;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;


public class GeomFromTextTest {

	public static final String geoJsonTestGeom="POINT (-48.23456,20.12345)";
	
	@Test
	public void testGeomFromText() throws ParseException {
        GeomFromText instance=new GeomFromText();
        ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(geoJsonTestGeom, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac,geo);
		Value expResult=valfac.createLiteral(geoJsonTestGeom, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
