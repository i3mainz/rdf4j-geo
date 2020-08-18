package org.eclipse.rdf4j.testsuites.postgis.point.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.CollectionHomogenize;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;

public class AzimuthTest {

	public static final String testPoint1="POINT(25, 45)";
	
	public static final String testPoint2="POINT(75, 100)";

	@Test
	public void testAzimuth1() {
		Azimuth instance=new Azimuth();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POINT (0 0)",WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
        Azimuth instance=new Azimuth();
        NodeValue geom1 = GeometryWrapperFactory.createPoint(new Coordinate(25.,45.), WKTDatatype.URI).asNodeValue();
        NodeValue geom2 = GeometryWrapperFactory.createPoint(new Coordinate(75.,100.), WKTDatatype.URI).asNodeValue();
        NodeValue expResult = NodeValue.makeDouble(42.2736890060937);
        NodeValue result = instance.exec(geom1,geom2);
        assertEquals(expResult, result);
	}

	@Test
	public void testAzimuth2() {
        Azimuth instance=new Azimuth();
        NodeValue geom1 = GeometryWrapperFactory.createPoint(new Coordinate(25.,45.), WKTDatatype.URI).asNodeValue();
        NodeValue geom2 = GeometryWrapperFactory.createPoint(new Coordinate(75.,100.), WKTDatatype.URI).asNodeValue();
        NodeValue expResult = NodeValue.makeDouble(222.273689006094);
        NodeValue result = instance.exec(geom2,geom1);
        assertEquals(expResult, result);
	}
	
}
