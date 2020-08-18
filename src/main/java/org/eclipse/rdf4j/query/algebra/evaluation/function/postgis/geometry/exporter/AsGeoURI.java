package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;


/**
 * Returns a GeoURI representation of a given geometry.
 */
public class AsGeoURI extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
        if("POINT".equalsIgnoreCase(geom.getGeometryType())) {
        	return "geo:"+geom.getCoordinate().x+","+geom.getCoordinate().y+";crs=EPSG:"+geom.getSRID();
        }
        return "geo:"+geom.getCentroid().getCoordinate().x+","+geom.getCentroid().getCoordinate().y+";crs=EPSG:"+geom.getSRID();
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGEOURI.stringValue();
	}

}
