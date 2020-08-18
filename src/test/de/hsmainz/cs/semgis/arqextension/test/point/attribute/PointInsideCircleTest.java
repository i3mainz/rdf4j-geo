package de.hsmainz.cs.semgis.arqextension.test.point.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute.PointInsideCircle;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class PointInsideCircleTest {

	public static final String testPoint="POINT (1 2)";
	
	@Test
	public void testPoitnInsideCircleTrue() {
		PointInsideCircle instance=new PointInsideCircle();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPoint, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,valfac.createLiteral(1.0),valfac.createLiteral(1.0),valfac.createLiteral(4.0));
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testPointInsideCircleFalse() {
		PointInsideCircle instance=new PointInsideCircle();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPoint, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,valfac.createLiteral(100.0),valfac.createLiteral(100.0),valfac.createLiteral(2.0));
		Value expResult=valfac.createLiteral(true);
		assertEquals(expResult, result);
	}
	
}
