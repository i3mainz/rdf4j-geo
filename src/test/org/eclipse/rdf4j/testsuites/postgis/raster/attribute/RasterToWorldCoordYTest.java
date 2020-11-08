package org.eclipse.rdf4j.testsuites.postgis.raster.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute.RasterToWorldCoordY;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.HexWKBRastDatatype;
import org.eclipse.rdf4j.testsuites.postgis.util.SampleRasters;
import org.junit.jupiter.api.Test;

public class RasterToWorldCoordYTest extends SampleRasters {
	
	@Test
	public void testRasterToWorldCoordY() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(wkbString1, HexWKBRastDatatype.LiteralIRI);
        Value x = valfac.createLiteral(1);
        Value y = valfac.createLiteral(1);
        RasterToWorldCoordY instance=new RasterToWorldCoordY();
        Value expResult = valfac.createLiteral(1.0);
        Value result= instance.evaluate(valfac,cov1,x,y);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
