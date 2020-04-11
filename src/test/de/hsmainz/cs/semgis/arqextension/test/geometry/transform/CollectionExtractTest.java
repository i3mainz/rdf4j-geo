package de.hsmainz.cs.semgis.arqextension.test.geometry.transform;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.CollectionExtract;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.io.ParseException;

public class CollectionExtractTest {

	public static final String testGeometry="GEOMETRYCOLLECTION(POINT(0 0))";

	public static final String res="POINT(0 0)";
		
		@Test
		public void testCollectionExtract() throws ParseException {
	        CollectionExtract instance=new CollectionExtract();
			ValueFactory valfac=SimpleValueFactory.getInstance();
			Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
			Value result=instance.evaluate(valfac, geo,valfac.createLiteral(1));
			Value expResult=valfac.createLiteral(res,WKTDatatype.LiteralIRI);
			assertEquals(expResult, result);
		}
	
}
