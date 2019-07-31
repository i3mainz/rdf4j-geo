package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

public class GPXDatatype extends VectorLiteral {

	private static final Logger LOGGER = LoggerFactory.getLogger(GPXDatatype.class);

    /**
     * The default WKT type URI.
     */
    public static final String URI = POSTGIS.HEXWKB;

    /**
     * A static instance of WKTDatatype.
     */
    public static final GPXDatatype INSTANCE = new GPXDatatype();
    
	String out=		"<?xml version='1.0' encoding='UTF-8' standalone='no' ?>" + 
			"<gpx version='1.0'>"+
			"<name>Example gpx</name>";
		String out2= 
			"  <trk>" + 
			"    <name>Example gpx</name>" + 
			"    <trkseg>";
	String out3=" </trkseg></trk></gpx>";
	

	@Override
	public Geometry read(String geometryLiteral) {

		try {
			SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
			InputStream stream = new ByteArrayInputStream(geometryLiteral.getBytes(StandardCharsets.UTF_8));
			de.hsmainz.cs.semgis.arqextension.util.GPXHandler handler=new de.hsmainz.cs.semgis.arqextension.util.GPXHandler();
			parser.parse(stream, handler);
			if(handler.coordinates.size()==1 && handler.coordinates.get(0).size()==1) {
				return GeometryWrapperFactory.createPoint(handler.coordinates.get(0).get(0), URI);
			}
			if(handler.coordinates.size()==1 && handler.coordinates.get(0).size()>1) {
				return GeometryWrapperFactory.createLineString(handler.coordinates.get(0), URI);
			}
			/*if(handler.coordinates.size()>1 && handler.coordinates.get(0).size()>1) {
			return GeometryWrapperFactory.createMultiLineString(lineStrings, URI);
			}*/
		} catch (SAXException | IOException | ParserConfigurationException e) {
			throw new AssertionError("There was an error parsing GPXLiteral: " + geometryLiteral);
		}
		throw new AssertionError("Error parsing GPXLiteral: " + geometryLiteral);
	}
	
	
	
	@Override
	public String unparse(Geometry geom) {
            StringBuilder trackpoints=new StringBuilder();
            for(Coordinate coord:geom.getCoordinates()) {
            	trackpoints.append("<trkpt lat='"+coord.x+"' lon='"+coord.y+"'>");
            	if(!Double.isNaN(coord.getZ()))
            		trackpoints.append("<ele>"+coord.getZ()+"</ele>");
            	trackpoints.append("</trkpt>");
            }
            return out+out2+trackpoints+out3;
	}

}
