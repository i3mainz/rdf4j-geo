package org.eclipse.rdf4j.testsuites.postgis.geometry.srid;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid.EPSGToWKT;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid.GeomCRSToWKT;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.Test;

public class GeomCRSToWKTTest {

	String epsg="EPSG:4326";
	
	Integer srid=4326;
	
	public static final String testPoint="<http://www.opengis.net/def/crs/EPSG/0/4326> POINT(1 2 3)";
	
	String epsg4326wkt="GEODCRS[\"WGS 84\",DATUM[\"World Geodetic System 1984\",ELLIPSOID[\"WGS 84\", 6378137.0, 298.257223563, LENGTHUNIT[\"metre\", 1]]],PRIMEM[\"Greenwich\", 0.0, ANGLEUNIT[\"degree\", 0.017453292519943295]],CS[ellipsoidal, 2],AXIS[\"Latitude (B)\", north, ORDER[1]],AXIS[\"Longitude (L)\", east, ORDER[2]],ANGLEUNIT[\"degree\", 0.017453292519943295],SCOPE[\"Horizontal component of 3D system. Used by the GPS satellite navigation system and for NATO military geodetic surveying.\"],AREA[\"World.\"],BBOX[-90.00, -180.00, 90.00, 180.00],ID[\"EPSG\", 4326, \"9.7\", URI[\"urn:ogc:def:crs:EPSG:9.7:4326\"]]]";
	
	@Test
	public void testGeomCRSToWKT() {
		GeomCRSToWKT is3d=new GeomCRSToWKT();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testPoint,WKTDatatype.LiteralIRI);
		Value result=is3d.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral(epsg4326wkt);
	    assertEquals(expResult, result);
	}
	
}
