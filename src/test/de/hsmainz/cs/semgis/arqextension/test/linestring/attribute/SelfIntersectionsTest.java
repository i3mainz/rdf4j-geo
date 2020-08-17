package de.hsmainz.cs.semgis.arqextension.test.linestring.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.MaxDistance;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.attribute.SelfIntersections;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class SelfIntersectionsTest {

	public static final String testGeom="LINESTRING(77.29 29.07,77.42 29.26,77.27 29.31,77.29 29.07)";

	public static final String testGeom2="LINESTRING(77.29 29.07,77.42 29.26,77.27 29.31)";
	
	public static final String intersectResult="MULTIPOINT ((77.29 29.07))";

	public static final String intersectResult2="MULTIPOINT EMPTY";
	
	@Test
	public void testSelfIntersections() {
		SelfIntersections instance=new SelfIntersections();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(intersectResult, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

	@Test
	public void testNoSelfIntersections() {
		SelfIntersections instance=new SelfIntersections();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(intersectResult2, WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

}

