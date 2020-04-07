package de.hsmainz.cs.semgis.arqextension.test.unit;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.functions.units.DecimeterToMeter;
import org.junit.jupiter.api.Test;


public class DecimeterToMeterTest {

	@Test
	public void testDecimeterToMeter() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value unitamount = valfac.createLiteral(1.);
        DecimeterToMeter instance=new DecimeterToMeter();
        Value expResult = valfac.createLiteral(0.1);
        Value result= instance.evaluate(valfac,unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
