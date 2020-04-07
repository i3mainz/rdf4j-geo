package de.hsmainz.cs.semgis.arqextension.test.raster.algebra;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.algebra.Invert;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;

public class InvertTest extends SampleRasters {

	public static final String combinedRasterLiteral="";
	
	@Test
	public void testInvert() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        Invert instance=new Invert();
        Value expResult = valfac.createLiteral(combinedRasterLiteral, CovJSONDatatype.LiteralIRI);
        Value result= instance.evaluate(valfac,cov1);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
