package org.eclipse.rdf4j.testsuites.postgis.raster.algebra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.algebra.AndConst;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.HexWKBRastDatatype;
import org.eclipse.rdf4j.testsuites.postgis.util.SampleRasters;
import org.junit.jupiter.api.Test;


public class AndConstTest extends SampleRasters {

	public static final String combinedRasterLiteral="";
	
	@Test
	public void testAndConst() {
        System.out.println(displayRasterSummary(wkbString4));
		ValueFactory valfac=SimpleValueFactory.getInstance();
        Value cov1 = valfac.createLiteral(wkbString4, HexWKBRastDatatype.LiteralIRI);
        Value constt = valfac.createLiteral(10);
        AndConst instance=new AndConst();
        Value expResult = valfac.createLiteral(wkbString4, HexWKBRastDatatype.LiteralIRI);
        Value result= instance.evaluate(valfac,cov1,valfac.createLiteral(1),constt);
        System.out.println(displayRasterSummary(wkbString4));
        System.out.println(displayRasterSummary(result));
        assertNotEquals(expResult, result);
	}

}
