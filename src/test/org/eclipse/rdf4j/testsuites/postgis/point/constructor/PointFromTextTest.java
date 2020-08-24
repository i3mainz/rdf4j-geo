package org.eclipse.rdf4j.testsuites.postgis.point.constructor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.constructor.PointFromText;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.Test;

public class PointFromTextTest {

	@Test
	public void testPointFromText() {
		PointFromText is3d=new PointFromText();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral("POINT (0 0)");
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("POINT (0 0)",WKTDatatype.LiteralIRI);
	    assertEquals(expResult, result);
	}
	
}
