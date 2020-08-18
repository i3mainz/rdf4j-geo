package org.eclipse.rdf4j.testsuites.postgis.geometry.srid;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid.SRIDToEPSG;
import org.junit.Test;

public class SRIDToEPSGTest {

	String epsg="EPSG:4326";
	
	Integer srid=4326;
	
	@Test
	public void testEPSGToSRID() {
		SRIDToEPSG is3d=new SRIDToEPSG();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(srid);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(epsg);
	    assertEquals(expResult, result);
	}
	
}
