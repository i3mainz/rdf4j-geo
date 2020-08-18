package org.eclipse.rdf4j.testsuites.postgis.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.IsCollection;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class IsCollectionTest {
	
	@Test
	public void testMultiPointIsCollection() {
		IsCollection is3d=new IsCollection();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/27700> MULTIPOINT (10 40, 40 30, 20 20, 30 10)", WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testMultiPolygonIsCollection() {
		IsCollection is3d=new IsCollection();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/27700> MULTIPOLYGON (((40 40, 20 45, 45 30, 40 40)),((20 35, 10 30, 10 10, 30 5, 45 20, 20 35),(30 20, 20 15, 20 25, 30 20)))", WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
	    assertEquals(expResult, result);
	}

	@Test
	public void testMultiLineStringIsCollection() {
		IsCollection is3d=new IsCollection();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/27700> MULTILINESTRING ((10 10, 20 20, 10 40),(40 40, 30 30, 40 20, 30 10))", WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testGeometryCollectionIsCollection() {
		IsCollection is3d=new IsCollection();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/27700> GEOMETRYCOLLECTION(POINT(4 6),LINESTRING(4 6,7 10))", WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(true);
	    assertEquals(expResult, result);
	}
	

	@Test
	public void testPointIsCollection() {
		IsCollection is3d=new IsCollection();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/27700> POINT (30 10)", WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testLineStringIsCollection() {
		IsCollection is3d=new IsCollection();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/27700> LINESTRING (30 10, 10 30, 40 40)", WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testPolygonIsCollection() {
		IsCollection is3d=new IsCollection();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/27700> POLYGON ((30 10, 40 40, 20 40, 10 20, 30 10))", WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(false);
	    assertEquals(expResult, result);
	}	

	
	
}
