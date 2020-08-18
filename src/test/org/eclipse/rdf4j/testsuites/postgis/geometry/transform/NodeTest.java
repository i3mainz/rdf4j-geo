package org.eclipse.rdf4j.testsuites.postgis.geometry.transform;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.FlipCoordinates;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform.Node;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXYZM;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;


public class NodeTest {

	public static final String testGeom="POLYGON((0 0 1,0 5 1,5 0 1,0 0 1),(1 1 1,3 1 1,1 3 1,1 1 1))";

	public static final String result="POLYGON((0 0 1,0 5 1,5 0 1,0 0 1),(1 1 1,3 1 1,1 3 1,1 1 1))";
	
	@Test
	public void testNode() {
		Node instance=new Node();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeom, WKTDatatype.LiteralIRI);
		Value resultt=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(result, WKTDatatype.LiteralIRI);
		assertEquals(expResult, resultt);
        NodeValue geometryLiteral = NodeValue.makeNode(testGeom, WKTDatatype.INSTANCE);
        
        List<Coordinate> coords=new LinkedList<Coordinate>();
        coords.add(new CoordinateXYZM(0,0,0,1));
        coords.add(new CoordinateXYZM(0,5,0,2));
        coords.add(new CoordinateXYZM(5,0,0,0));
        coords.add(new CoordinateXYZM(0,0,0,0));
        Polygon poly=(Polygon) GeometryWrapperFactory.createPolygon(coords, WKT.DATATYPE_URI).getXYGeometry();
        List<Geometry> polylist=new LinkedList<Geometry>();
        polylist.add(poly);
        //        POLYGON((0 0,0 5,5 0,0 0),(1 1,3 1,1 3,1 1))
        NodeValue result = instance.exec(geometryLiteral);
        System.out.println(result);
        NodeValue expResult = GeometryWrapperFactory.createGeometryCollection(polylist, ""+poly.getSRID(), WKT.DATATYPE_URI).asNodeValue();

        assertEquals(expResult, result);
	}
	
}
