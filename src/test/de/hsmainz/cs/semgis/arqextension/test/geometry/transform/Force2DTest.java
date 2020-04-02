package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.Force2D;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class Force2DTest {

public static final String testPolygon="POLYGON((0 0 2,0 5 2,5 0 2,0 0 2))";
	
	@Test
	public void testForce2D() {
		Force2D instance=new Force2D();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POLYGON ((0 0, 0 5, 5 0, 0 0))", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
}
