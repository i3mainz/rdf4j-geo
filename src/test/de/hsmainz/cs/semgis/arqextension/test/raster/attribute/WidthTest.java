package de.hsmainz.cs.semgis.arqextension.test.raster.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute.Width;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.junit.Test;

import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;


public class WidthTest extends SampleRasters {
	
	@Test
	public void testRasterWidth() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        Width instance=new Width();
        Value expResult = valfac.createLiteral(10.);
        Value result= instance.evaluate(valfac,cov1);
        System.out.println(result);
        assertEquals(expResult, result);
	}
	
}
