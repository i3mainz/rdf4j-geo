package de.hsmainz.cs.semgis.arqextension.test.unit;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.functions.units.CentimeterToMeter;
import org.junit.jupiter.api.Test;


public class CentimeterToMeterTest {

	@Test
	public void testCentimeterToMeter() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value unitamount = valfac.createLiteral(100.);
        CentimeterToMeter instance=new CentimeterToMeter();
        Value expResult = valfac.createLiteral(1.);
        Value result= instance.evaluate(valfac,unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
