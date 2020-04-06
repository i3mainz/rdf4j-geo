package de.hsmainz.cs.semgis.arqextension.test.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.IntersectionMatrix;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class IntersectionMatrixTest {

	public static final String testGeom="LINESTRING(743238 2967416,743238 2967450,743265 2967450, 743265.625 2967416,743238 2967416)";

	public static final String testGeom2="MULTIPOINT (0 1, 1 0, 2 1)";
	
	public static final String testGeom3="<http://www.opengis.net/def/crs/EPSG/0/27700> MULTIPOINT (10 40, 40 30, 20 20, 30 10)";

	public static final String testGeom4="<http://www.opengis.net/def/crs/EPSG/0/4326> MULTIPOINT (10 40, 40 30, 20 20, 30 10)";
	
	@Test
	public void testIntersectionMatrix() {
		IntersectionMatrix instance=new IntersectionMatrix();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom3, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom3, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral("0FFFFFFF2");
		assertEquals(expResult, result);
	}
	
}
