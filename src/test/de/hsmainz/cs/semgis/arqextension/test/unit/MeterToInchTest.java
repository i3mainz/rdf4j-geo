package de.hsmainz.cs.semgis.arqextension.test.unit;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.functions.units.MeterToInch;
import org.junit.jupiter.api.Test;


public class MeterToInchTest {

	@Test
	public void testMeterToInch() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value unitamount = valfac.createLiteral(0.0254);
        MeterToInch instance=new MeterToInch();
        Value expResult = valfac.createLiteral(1.);
        Value result= instance.evaluate(valfac,unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
