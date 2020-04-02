package de.hsmainz.cs.semgis.arqextension.test.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.HausdorffDistance;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;	

public class HausdorffDistanceTest {

	public static final String testGeom1="LINESTRING (0 0, 2 0)";
	
	public static final String testGeom2="MULTIPOINT (0 1, 1 0, 2 1)";
	
	public static final String testGeom3="LINESTRING (130 0, 0 0, 0 150)";
	
	public static final String testGeom4="LINESTRING (10 10, 10 150, 130 10)";
	
	@Test
	public void testHausdorffDistance() {
		HausdorffDistance instance=new HausdorffDistance();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom1, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(1.);
		assertEquals(expResult, result);
	}
	
}
