package org.eclipse.rdf4j.testsuites.postgis.geometry.constructor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.constructor.GeomFromGeoJSON;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.GeoJSONDatatype;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;


public class GeomFromGeoJSONTest {

	public static final String geoJsonTestGeom="{\"type\":\"Point\",\"coordinates\":[-48.23456,20.12345]}";
	
	@Test
	public void testGeomFromGeoJSON() throws ParseException {
		GeomFromGeoJSON instance=new GeomFromGeoJSON();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(geoJsonTestGeom, GeoJSONDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac,geo);
		Value expResult=valfac.createLiteral("POINT (-48.23456 20.12345)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
