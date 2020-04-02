package de.hsmainz.cs.semgis.arqextension.test.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.NumDistinctPoints;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;



public class NumDistinctPointsTest {

public static final String testGeom="LINESTRING(77.29 29.07,77.42 29.26,77.27 29.31,77.29 29.07)";
	
	@Test
	public void testNumDistinctPoints() {
		NumDistinctPoints instance=new NumDistinctPoints();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(3);
	    assertEquals(expResult, result);
	}
	
}
