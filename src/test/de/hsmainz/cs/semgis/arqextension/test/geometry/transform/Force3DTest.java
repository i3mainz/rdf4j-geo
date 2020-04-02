package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.Force3D;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class Force3DTest {

public static final String testPolygon="POLYGON((0 0,0 5,5 0,0 0))";
	
	@Test
	public void testForce3D() {
		Force3D instance=new Force3D();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POLYGON Z ((0 0 0, 0 5 0, 5 0 0, 0 0 0))", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
