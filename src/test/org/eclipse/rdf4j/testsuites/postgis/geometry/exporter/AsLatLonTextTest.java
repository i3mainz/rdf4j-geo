package org.eclipse.rdf4j.testsuites.postgis.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsLatLonText;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class AsLatLonTextTest {
	
public static final String testGeometry="POINT(49.9928617 8.2472526)";
	
	@Test
	public void testAsLatLonText() {
		AsLatLonText instance=new AsLatLonText();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("49.9928617°59.57170199999993'34.302119999983915\"N 8.2472526°14.83515599999997'50.109359999999015\"E");
	    assertEquals(expResult, result);
	}

}
