package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.wololo.geojson.GeoJSON;
import org.wololo.jts2geojson.GeoJSONWriter;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class AsGeoJSON extends GeometricStringExportFunction{

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGEOJSON.stringValue();
	}

	@Override
	public String operation(Geometry geom) {
         GeoJSONWriter writer = new GeoJSONWriter();
         GeoJSON json = writer.write(geom);
         return  json.toString();
	}

}
