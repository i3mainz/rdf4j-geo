package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.Force3DM;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class Force3DMTest {

	public static final String testPolygon="POLYGON((0 0 1,0 5 1,5 0 1,0 0 1))";
	
	public static final String testPolygon2="POLYGON((0 0,0 5,5 0,0 0))";
	
	@Test
	public void testForce3DM() {
		Force3DM instance=new Force3DM();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POLYGON ((0 0 0, 0 5 0, 5 0 0, 0 0 0))",WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

	@Test
	public void testForce3DM2() {
		Force3DM instance=new Force3DM();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POLYGON ((0 0 0, 0 5 0, 5 0 0, 0 0 0))",WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
