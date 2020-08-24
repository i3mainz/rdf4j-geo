package org.eclipse.rdf4j.testsuites.postgis.geometry.constructor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.constructor.GeomFromWKB;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKBDatatype;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;


public class GeomFromWKBTest {

public static final String geoJsonTestGeom="\\001\\002\\000\\000\\000\\002\\000\\000\\000\\037\\205\\353Q\\270~\\\\\\300\\323Mb\\020X\\231C@\\020X9\\264\\310~\\\\\\300)\\\\\\217\\302\\365\\230C@";
	
	@Test
	public void testGeomFromWKB() throws ParseException {		
        GeomFromWKB instance=new GeomFromWKB();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(geoJsonTestGeom, WKBDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac,geo);
		Value expResult=valfac.createLiteral("POINT (-48.23456 20.12345)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
