package de.hsmainz.cs.semgis.arqextension.test.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.IsPlanar;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.Test;

public class IsPlanarTest {


@Test
public void testIsPlanarTrue() {
	IsPlanar instance=new IsPlanar();
	ValueFactory valfac=SimpleValueFactory.getInstance();
	Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/27700> MULTIPOINT (10 40, 40 30, 20 20, 30 10)", WKTDatatype.LiteralIRI);
	Value result=instance.evaluate(valfac, geo);
	Value expResult=valfac.createLiteral(true);
    assertEquals(expResult, result);
}

}
