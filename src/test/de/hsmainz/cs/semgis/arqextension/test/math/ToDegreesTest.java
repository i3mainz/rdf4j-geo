package de.hsmainz.cs.semgis.arqextension.test.math;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.math.ToDegrees;
import org.junit.jupiter.api.Test;

public class ToDegreesTest {

	@Test
	public void testRadiansToDegrees() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value unitamount = valfac.createLiteral(0.3);
        ToDegrees instance=new ToDegrees();
        Value expResult = valfac.createLiteral(17.188733853924695);
        Value result= instance.evaluate(valfac,unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
