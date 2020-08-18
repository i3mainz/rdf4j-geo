package org.eclipse.rdf4j.testsuites.postgis.raster.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform.Resize;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.eclipse.rdf4j.testsuites.postgis.util.SampleRasters;
import org.junit.jupiter.api.Test;


public class RescaleTest extends SampleRasters {
	
	@Test
	public void testRasterValue() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        Resize instance=new Resize();
        Value height = valfac.createLiteral(10.);
        Value width = valfac.createLiteral(10.);
        Value band = valfac.createLiteral(10.);
        Value expResult = valfac.createLiteral(0.);
        Value result= instance.evaluate(valfac,cov1,height,width);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
