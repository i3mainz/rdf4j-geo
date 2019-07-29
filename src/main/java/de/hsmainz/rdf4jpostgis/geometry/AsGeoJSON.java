package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;
import org.wololo.geojson.GeoJSON;
import org.wololo.jts2geojson.GeoJSONWriter;

public class AsGeoJSON extends GeometricStringExportFunction{

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String operation(Geometry geom) {
         GeoJSONWriter writer = new GeoJSONWriter();
         GeoJSON json = writer.write(geom);
         return  json.toString();
	}

}
