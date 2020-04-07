package de.hsmainz.cs.semgis.arqextension.test.raster.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.exporter.AsCoverageJSON;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.junit.jupiter.api.Test;

import de.hsmainz.cs.semgis.arqextension.test.util.SampleRasters;


public class AsCoverageJSONTest extends SampleRasters {
	
	@Test
	public void testAsCoverageJSON() {
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(rasterLiteral1, CovJSONDatatype.LiteralIRI);
        AsCoverageJSON instance=new AsCoverageJSON();
        Value expResult = valfac.createLiteral(covJSONString1);
        Value result= instance.evaluate(valfac,cov1);
        System.out.println(result);
        assertEquals(expResult, result);
	}

}
