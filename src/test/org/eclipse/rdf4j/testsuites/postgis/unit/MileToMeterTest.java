package org.eclipse.rdf4j.testsuites.postgis.unit;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.unit.MileToMeter;
import org.junit.jupiter.api.Test;

public class MileToMeterTest {

	@Test
	public void testMileToMeter() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value unitamount = valfac.createLiteral(1.);
        MileToMeter instance=new MileToMeter();
        Value expResult = valfac.createLiteral(1609.3470878864446);
        Value result= instance.evaluate(valfac,unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
