package de.hsmainz.cs.semgis.arqextension.test.raster.constructor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;


public class RastFromHexWKBTest extends SampleRasters {
	
	@Test
	public void testTileHeight() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(wkbString1);
        org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.constructor.RastFromHexWKB instance=new org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.constructor.RastFromHexWKB();
        Value expResult = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        Value result= instance.evaluate(valfac,cov1);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
