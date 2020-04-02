package de.hsmainz.cs.semgis.arqextension.test.geometry.editor;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.editor.SetEndPoint;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class SetEndPointTest {

	public static final String LineString2D="LINESTRING(0 1, 0 2)";
	
	public static final String point="POINT(1 1)";
	
	@Test
	public void testLineString2D() {
		SetEndPoint instance=new SetEndPoint();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(LineString2D, WKTDatatype.LiteralIRI);
		Value geo2=valfac.createLiteral(point, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo,geo2);
		Value expResult=valfac.createLiteral("LINESTRING (0 1, 1 1)", WKTDatatype.LiteralIRI);
		assertEquals(expResult, result);

	}
	
}
