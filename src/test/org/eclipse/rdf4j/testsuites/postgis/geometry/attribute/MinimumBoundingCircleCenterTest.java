package org.eclipse.rdf4j.testsuites.postgis.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.MinimumBoundingCircleCenter;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class MinimumBoundingCircleCenterTest {

	public static final String testPolygon="POLYGON((26426 65078,26531 65242,26075 65136,26096 65427,26426 65078))";
	
	public static final String result="POINT (26284.841802713276 65267.11450908256)";
	
	@Test
	public void testMinimumBoundingCircle() {
		MinimumBoundingCircleCenter instance=new MinimumBoundingCircleCenter();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value resultt=instance.evaluate(valfac,geo);
		Value expResult=valfac.createLiteral(result, WKTDatatype.LiteralIRI);
		assertEquals(expResult, resultt);
	}
	
}
