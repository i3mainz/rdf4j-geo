package main.java.de.hsmainz.rdf4jpostgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;

public class AsGPX extends GeometricStringExportFunction {

	
	
	String out="<?xml version='1.0' encoding='UTF-8' standalone='no' ?>" + 
			"<gpx version='1.0'>"+
			"<name>Example gpx</name>";
		String out2= 
			"  <trk>" + 
			"    <name>Example gpx</name>" + 
			"    <trkseg>";
	String out3=" </trkseg></trk></gpx>";
	
	@Override
	public String operation(Geometry geom) {
        StringBuilder trackpoints=new StringBuilder();
        for(Coordinate coord:geom.getCoordinates()) {
        	trackpoints.append("<trkpt lat='"+coord.x+"' lon='"+coord.y+"'>");
        	if(!Double.isNaN(coord.getZ()))
        		trackpoints.append("<ele>"+coord.getZ()+"</ele>");
        	trackpoints.append("</trkpt>");
        }
        return out+out2+trackpoints+out3;
	}

	@Override
	public String getURI() {
		return POSTGIS.ASGPX.stringValue();
	}

}
