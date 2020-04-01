package de.hsmainz.cs.semgis.arqextension.test.geometry.attribute;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.IsEmpty;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute.IsSolid;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.Test;

public class IsEmptyTest {


@Test
public void testIsEmptyFalse() {
	IsEmpty is3d=new IsEmpty();
	ValueFactory valfac=SimpleValueFactory.getInstance();
	Value geo=valfac.createLiteral("<http://www.opengis.net/def/crs/EPSG/0/27700> MULTIPOINT (10 40, 40 30, 20 20, 30 10)", WKTDatatype.LiteralIRI);
	Value result=is3d.evaluate(valfac, geo);
	Value expResult=valfac.createLiteral(false);
    assertEquals(expResult, result);
}


@Test
public void testIsEmptyTrue() {
	IsEmpty is3d=new IsEmpty();
	ValueFactory valfac=SimpleValueFactory.getInstance();
	Value geo=valfac.createLiteral("MULTIPOINT EMPTY", WKTDatatype.LiteralIRI);
	Value result=is3d.evaluate(valfac, geo);
	Value expResult=valfac.createLiteral(true);
    assertEquals(expResult, result);
}

}
