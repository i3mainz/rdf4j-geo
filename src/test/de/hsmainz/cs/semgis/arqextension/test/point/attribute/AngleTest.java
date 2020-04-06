package de.hsmainz.cs.semgis.arqextension.test.point.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute.Angle;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class AngleTest {

	public static final String testPoint1="POINT(25 45)";
	
	public static final String testPoint2="POINT(75 100)";
	
	public static final String testPoint3="POINT(50 80)";

	@Test
	public void testAngle() {
		Angle instance=new Angle();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPoint1, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testPoint2, WKTDatatype.LiteralIRI);
		Value geo3=valfac.createLiteral(testPoint3, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2,geo3);
		Value expResult=valfac.createLiteral(0.15824032445087835);
		assertEquals(expResult, result);
	}
	
}
