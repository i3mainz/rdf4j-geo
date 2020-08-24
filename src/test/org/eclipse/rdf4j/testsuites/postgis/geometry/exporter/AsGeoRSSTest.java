package org.eclipse.rdf4j.testsuites.postgis.geometry.exporter;

import static org.junit.Assert.assertEquals;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter.AsGeoRSS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.WKTDatatype;
import org.junit.jupiter.api.Test;

public class AsGeoRSSTest {

	public static final String testGeometry="POINT(49.9928617 8.2472526)";
	
	@Test
	public void testAsGeoRSS() {
		AsGeoRSS instance=new AsGeoRSS();
		ValueFactory valfac=SimpleValueFactory.getInstance();
		Value geo=valfac.createLiteral(testGeometry, WKTDatatype.LiteralIRI);
		Value result=instance.evaluate(valfac, geo);
		Value expResult=valfac.createLiteral("<\"geo:49.9928617,8.2472526;crs=EPSG:0\"> but was:<\"<?xml version=\"1.0\" encoding=\"UTF-8\"?><rss version=\"2.0\"xmlns:georss=\"http://www.georss.org/georss\"xmlns:gml=\"http://www.opengis.net/gml\"><channel><link>http://www.i3mainz.de/postgis-jena</link><title>Cambridge Neighborhoods</title><description>One guy's view of Cambridge, MA</description><item><guid isPermaLink=\"false\">00000111c36421c1321d3</guid><pubDate>1598306749924</pubDate><gml:Point>\r\n" + 
				"<gml:coordinates>\r\n" + 
				"49.9928617,8.2472526 \r\n" + 
				"</gml:coordinates>\r\n" + 
				"</gml:Point>\r\n" + 
				"</item></channel></rss>");
	    assertEquals(expResult, result);
	}
	
}
