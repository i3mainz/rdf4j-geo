package de.hsmainz.cs.semgis.arqextension.test.raster.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute.Band;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;

public class BandTest extends SampleRasters {
	
	@Test
	public void testBand() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        Value bandno = valfac.createLiteral(1);
        Band instance=new Band();
        Value expResult =valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        Value result= instance.evaluate(valfac,cov1,bandno);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
