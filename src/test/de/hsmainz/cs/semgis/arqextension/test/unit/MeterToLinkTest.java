package de.hsmainz.cs.semgis.arqextension.test.unit;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.functions.units.MeterToLink;
import org.junit.jupiter.api.Test;

public class MeterToLinkTest {

	@Test
	public void testMeterToLink() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value unitamount = valfac.createLiteral(1.);
        MeterToLink instance=new MeterToLink();
        Value expResult = valfac.createLiteral(4.970969537898672);
        Value result= instance.evaluate(valfac,unitamount);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
