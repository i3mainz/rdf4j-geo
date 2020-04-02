package de.hsmainz.cs.semgis.arqextension.test.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsBinary;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class AsBinaryTest {

public static final String testGeometry="POLYGON((0 0,0 1,1 1,1 0,0 0))";
	
	@Test
	public void testAsBinary() {
		AsBinary instance=new AsBinary();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("\\001\\003\\000\\000\\000\\001\\000\\000\\000\\005\n" + 
        		"\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\n" + 
        		"\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\n" + 
        		"\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\n" + 
        		"\\000\\000\\000\\360?\\000\\000\\000\\000\\000\\000\n" + 
        		"\\360?\\000\\000\\000\\000\\000\\000\\360?\\000\\000\n" + 
        		"\\000\\000\\000\\000\\360?\\000\\000\\000\\000\\000\n" + 
        		"\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\\000\n" + 
        		"\\000\\000\\000\\000\\000\\000\\000\\000");
	    assertEquals(expResult, result);
	}
	
}
