package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.wololo.jts2geojson.GeoJSONReader;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

/**
 * Returns a geometry from a GeoJSON String.
 */
public class GeomFromGeoJSON extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
		GeoJSONReader reader = new GeoJSONReader();
		Geometry geom = reader.read(input);
        return geom;	 
	}

	@Override
	public String getURI() {
		return POSTGIS.st_geomFromGeoJSON.toString();
	}
}
