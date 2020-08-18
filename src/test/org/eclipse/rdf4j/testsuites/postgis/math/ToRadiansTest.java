package org.eclipse.rdf4j.testsuites.postgis.math;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.math.ToRadians;
import org.junit.jupiter.api.Test;

public class ToRadiansTest {

	@Test
	public void testDegreesToRadians() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value unitamount = valfac.createLiteral(17.188733853924695);
        ToRadians instance=new ToRadians();
        Value expResult = valfac.createLiteral(0.3);
        Value result= instance.evaluate(valfac,unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
	
}
