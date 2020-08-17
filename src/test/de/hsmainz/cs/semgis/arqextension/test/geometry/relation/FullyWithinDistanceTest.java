package de.hsmainz.cs.semgis.arqextension.test.geometry.relation;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.FullyWithinDistance;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation.MaxDistance;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class FullyWithinDistanceTest {

	public static final String testGeom="LINESTRING(77.29 29.07,77.42 29.26,77.27 29.31,77.29 29.07)";
	
	public static final String testGeom2="LINESTRING(5 5 ,10 10)";
	
	@Test
	public void testFullyWithinDistanceFalse() {
		FullyWithinDistance instance=new FullyWithinDistance();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(testGeom2, WKTDatatype.LiteralIRI);
		Value dist=valfac.createLiteral(10);
		Value result=instance.evaluate(valfac, geo,geo2,dist);
		Value expResult=valfac.createLiteral(false);
		assertEquals(expResult, result);
	}
	
}
