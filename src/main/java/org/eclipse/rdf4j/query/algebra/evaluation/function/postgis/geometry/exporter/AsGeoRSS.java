package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class AsGeoRSS extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
        AsGML asgml=new AsGML();
        String gml=asgml.operation(geom);
        return out+gml+out2;
	}
	
	String out="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
			  "<rss version=\"2.0\""+
			       "xmlns:georss=\"http://www.georss.org/georss\""+
			       "xmlns:gml=\"http://www.opengis.net/gml\">"+
			    "<channel>"+
			    "<link>http://www.i3mainz.de/postgis-jena</link>"+
			    "<title>Cambridge Neighborhoods</title>"+
			    "<description>One guy's view of Cambridge, MA</description>"+
			    "<item>"+
			      "<guid isPermaLink=\"false\">00000111c36421c1321d3</guid>"+
			      "<pubDate>"+System.currentTimeMillis()+"</pubDate>";
	String out2="</item></channel></rss>";
	@Override
	public String getURI() {
		return POSTGIS.ST_ASGEORSS.stringValue();
	}

}
