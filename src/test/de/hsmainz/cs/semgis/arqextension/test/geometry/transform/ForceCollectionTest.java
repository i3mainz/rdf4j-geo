package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.ForceCollection;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;


public class ForceCollectionTest {

	public static final String testGeom="POLYGON ((0 0, 0 5, 5 0, 0 0),(1 1, 3 1, 1 3, 1 1))";

	public static final String testGeomZ="POLYGON ((0 0 1,0 5 1,5 0 1,0 0 1),(1 1 1,3 1 1,1 3 1,1 1 1))";
	
	@Test
	public void testForceCollection() {
		ForceCollection instance=new ForceCollection();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("GEOMETRYCOLLECTION (POLYGON ((0 0, 0 5, 5 0, 0 0), (1 1, 3 1, 1 3, 1 1)))",WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}

	@Test
	public void testForceCollectionZ() {
		ForceCollection instance=new ForceCollection();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeomZ, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("GEOMETRYCOLLECTION (POLYGON ((0 0 1,0 5 1,5 0 1,0 0 1),(1 1 1,3 1 1,1 3 1,1 1 1)))",WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);
	}
	
	
}
