package main.java.de.hsmainz.rdf4jpostgis.geometry.exporter;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;

public class OSMLink extends GeometricStringExportFunction{

	@Override
	public String operation(Geometry geom) { 
        Envelope env = geom.getEnvelopeInternal();
        StringBuilder builder = new StringBuilder("http://www.openstreetmap.org/?");
        builder.append("minlon=").append(env.getMinY());
        builder.append("&minlat=").append(env.getMinX());
        builder.append("&maxlon=").append(env.getMaxY());
        builder.append("&maxlat=").append(env.getMaxX());
        Coordinate centre = env.centre();
        builder.append("&mlat=").append(centre.x);
        builder.append("&mlon=").append(centre.y);          
        return builder.toString();
	}

}
