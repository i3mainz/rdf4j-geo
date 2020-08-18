package org.eclipse.rdf4j.testsuites.postgis.geometry.srid;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid.EPSGToSRID;
import org.junit.Test;

public class EPSGToSRIDTest {

	String epsg="EPSG:4326";
			
	Integer srid=4326;
	
	@Test
	public void testEPSGToSRID() {
		EPSGToSRID is3d=new EPSGToSRID();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(epsg);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(srid);
	    assertEquals(expResult, result);
	}
	
}
