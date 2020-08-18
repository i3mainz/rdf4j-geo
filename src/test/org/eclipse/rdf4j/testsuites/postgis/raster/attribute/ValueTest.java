package org.eclipse.rdf4j.testsuites.postgis.raster.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.eclipse.rdf4j.testsuites.postgis.util.SampleRasters;
import org.junit.jupiter.api.Test;


public class ValueTest extends SampleRasters {
	
	@Test
	public void testRasterValue() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute.Value instance=new org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute.Value();
        Value cellx = valfac.createLiteral(10.);
        Value celly = valfac.createLiteral(10.);
        Value band = valfac.createLiteral(10.);
        Value expResult = valfac.createLiteral(0.);
        Value result= instance.evaluate(valfac,cov1,cellx,celly,band);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
