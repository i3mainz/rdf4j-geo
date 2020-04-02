package de.hsmainz.cs.semgis.arqextension.test.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.MinimumBoundingRadius;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class MinimumBoundingRadiusTest {

	public static final String testPolygon="POLYGON((26426 65078,26531 65242,26075 65136,26096 65427,26426 65078))";
	
	@Test
	public void testMinimumBoundingRadius() {
		MinimumBoundingRadius instance=new MinimumBoundingRadius();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPolygon, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(247.4360455914027);
	    assertEquals(expResult, result);
	}
	
}
