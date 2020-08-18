package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.Points;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class PointsTest {

	public static final String testGeometryZ="LINESTRING Z(1 2 3, 4 5 6)";
	
	public static final String testGeometry="LINESTRING (1 2, 4 5)";
	
	@Test
	public void testPoints() {
		Points instance=new Points();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("MULTIPOINT ((1 2), (4 5))",WKTDatatype.LiteralIRI);
	    assertEquals(expResult, result);
	}
	
	@Test
	public void testPoints3D() {
		Points instance=new Points();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometryZ, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("MULTIPOINT ((1 2 3), (4 5 6))",WKTDatatype.LiteralIRI);
	    assertEquals(expResult, result);
	}
	
}
