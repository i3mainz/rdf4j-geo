package org.eclipse.rdf4j.testsuites.postgis.unit;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.unit.MeterToUSYard;
import org.junit.jupiter.api.Test;


public class MeterToUSYardTest {

	@Test
	public void testMeterToUSYard() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value unitamount = valfac.createLiteral(1000.);
        MeterToUSYard instance=new MeterToUSYard();
        Value expResult = valfac.createLiteral(1094.0);
        Value result= instance.evaluate(valfac,unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
