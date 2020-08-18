package org.eclipse.rdf4j.testsuites.postgis.geometry.srid;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid.SridGetAxis1Orientation;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.Test;

public class SridGetAxis1OrientationTest {

	public static final String testPoint="<http://www.opengis.net/def/crs/EPSG/0/4326> POINT(1 2 3)";
	
	@Test
	public void testSridAxis1Orientation() {
		SridGetAxis1Orientation is3d=new SridGetAxis1Orientation();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/4326> MULTIPOINT (10 40, 40 30, 20 20, 30 10)", WKTDatatype.LiteralIRI);
		//Value geo=valfac.createLiteral(testPoint,WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("X");
	    assertEquals(expResult, result);
	}
	
}
