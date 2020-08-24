package org.eclipse.rdf4j.testsuites.postgis.geometry.srid;

import static org.junit.Assert.assertEquals;

import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid.SridGetAxis1Name;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.Test;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.util.FactoryException;

public class SridGetAxis1NameTest {

	public static final String testPoint="<http://www.opengis.net/def/crs/EPSG/0/4326> POINT(1 2 3)";
	
	@Test
	public void testSridGetAxis1Name() {
		try {
			CRS.forCode("EPSG:4326");
		} catch (NoSuchAuthorityCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SridGetAxis1Name is3d=new SridGetAxis1Name();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPoint,WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("X");
	    assertEquals(expResult, result);
	}
	
}
