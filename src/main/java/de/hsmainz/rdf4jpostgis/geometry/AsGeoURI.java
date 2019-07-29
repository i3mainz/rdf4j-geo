package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;


public class AsGeoURI extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
        if("POINT".equalsIgnoreCase(geom.getGeometryType())) {
        	return "geo:"+geom.getCoordinate().x+","+geom.getCoordinate().y+";crs=EPSG:"+geom.getSRID();
        }
        return "geo:"+geom.getCentroid().getCoordinate().x+","+geom.getCentroid().getCoordinate().y+";crs=EPSG:"+geom.getSRID();
	}

}
