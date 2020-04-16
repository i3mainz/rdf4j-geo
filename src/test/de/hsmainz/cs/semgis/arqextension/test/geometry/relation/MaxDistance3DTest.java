package de.hsmainz.cs.semgis.arqextension.test.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.MaxDistance3D;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class MaxDistance3DTest {

	public static final String testGeom="LINESTRING(77.29 29.07 3,77.42 29.26 4,77.27 29.31 5,77.29 29.07 3)";
	
	public static final String testGeom2="LINESTRING(5 5 1 ,10 10 2)";
	
	@Test
	public void testMaxDistance() {
		MaxDistance3D instance=new MaxDistance3D();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral(76.37541489249011e0);
		assertEquals(expResult, result);
	}
	
}
