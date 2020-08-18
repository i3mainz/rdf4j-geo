package org.eclipse.rdf4j.testsuites.postgis.raster.attribute;

import static org.junit.Assert.assertEquals;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute.NumYTiles;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.eclipse.rdf4j.testsuites.postgis.util.SampleRasters;
import org.junit.jupiter.api.Test;


public class NumYTilesTest extends SampleRasters {

	GridCoverage cov;
	
	@Test
	public void testNumYTiles() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        NumYTiles instance=new NumYTiles();
        Value expResult = valfac.createLiteral(10.);
        Value result= instance.evaluate(valfac,cov1);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
