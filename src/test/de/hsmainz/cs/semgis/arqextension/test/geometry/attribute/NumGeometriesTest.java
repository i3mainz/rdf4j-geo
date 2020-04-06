package de.hsmainz.cs.semgis.arqextension.test.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.NumGeometries;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class NumGeometriesTest {

	public static final String testGeom="LINESTRING(77.29 29.07,77.42 29.26,77.27 29.31,77.29 29.07)";
	
	public static final String testGeom2="GEOMETRYCOLLECTION(MULTIPOINT(-2 3 , -2 2),LINESTRING(5 5 ,10 10),POLYGON((-7 4.2,-7.1 5,-7.1 4.3,-7 4.2)))";
	
	@Test
	public void testNumGeometries() {
		NumGeometries instance=new NumGeometries();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value result=valfac.createLiteral(1);
		Value expResult=instance.evaluate(valfac, geo);
		assertEquals(expResult, result);
	}

	@Test
	public void testNumGeometriesCollection() {
		NumGeometries instance=new NumGeometries();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=valfac.createLiteral(3);
		Value expResult=instance.evaluate(valfac, geo);
		assertEquals(expResult, result);
	}
	
}
