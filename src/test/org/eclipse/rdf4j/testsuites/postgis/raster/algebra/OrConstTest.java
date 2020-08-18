package org.eclipse.rdf4j.testsuites.postgis.raster.algebra;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.algebra.OrConst;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.eclipse.rdf4j.testsuites.postgis.util.SampleRasters;
import org.junit.jupiter.api.Test;


public class OrConstTest extends SampleRasters {

	public static final String combinedRasterLiteral="";
	
	@Test
	public void testOrConst() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        Value cov2 = valfac.createLiteral(10);
        OrConst instance=new OrConst();
        Value expResult = valfac.createLiteral(combinedRasterLiteral, CovJSONDatatype.LiteralIRI);
        Value result= instance.evaluate(valfac,cov1,cov2);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
