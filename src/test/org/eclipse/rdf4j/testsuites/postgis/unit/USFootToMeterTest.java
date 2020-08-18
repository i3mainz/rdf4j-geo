package org.eclipse.rdf4j.testsuites.postgis.unit;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.unit.USFootToMeter;
import org.junit.jupiter.api.Test;

public class USFootToMeterTest {

	@Test
	public void testUSFootToMeter() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value unitamount = valfac.createLiteral(1.);
        USFootToMeter instance=new USFootToMeter();
        Value expResult = valfac.createLiteral(0.30480060991089725);
        Value result= instance.evaluate(valfac,unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
