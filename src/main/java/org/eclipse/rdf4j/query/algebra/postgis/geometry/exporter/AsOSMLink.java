package org.eclipse.rdf4j.query.algebra.postgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricStringExportFunction;

public class AsOSMLink extends GeometricStringExportFunction{

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

	@Override
	public String getURI() {
		return POSTGIS.st_osmlink.stringValue();
	}

}
