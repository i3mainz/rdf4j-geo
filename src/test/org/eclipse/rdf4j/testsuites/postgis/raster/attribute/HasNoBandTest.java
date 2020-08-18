package org.eclipse.rdf4j.testsuites.postgis.raster.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute.HasNoBand;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.eclipse.rdf4j.testsuites.postgis.util.SampleRasters;
import org.junit.jupiter.api.Test;


public class HasNoBandTest extends SampleRasters {
	
	@Test
	public void testHasNoBandTrue() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        Value bandno = valfac.createLiteral(1);
        HasNoBand instance=new HasNoBand();
        Value expResult = valfac.createLiteral(true);
        Value result= instance.evaluate(valfac,cov1,bandno);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
	@Test
	public void testHasNoBandFalse() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        Value bandno = valfac.createLiteral(100);
        HasNoBand instance=new HasNoBand();
        Value expResult = valfac.createLiteral(false);
        Value result= instance.evaluate(valfac,cov1,bandno);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
