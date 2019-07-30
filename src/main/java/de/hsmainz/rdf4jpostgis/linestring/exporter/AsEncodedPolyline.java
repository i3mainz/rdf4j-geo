package main.java.de.hsmainz.rdf4jpostgis.linestring.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;

public class AsEncodedPolyline extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		if (geom instanceof LineString) {
        	String result=encodePolyline((LineString)geom);
        	return result;
        }
		return null;
	}
	
	public static String encodePolyline(final LineString linestring) {
        long lastLat = 0;
        long lastLng = 0;

        final StringBuffer result = new StringBuffer();

        for (final Coordinate point : linestring.getCoordinates()) {
            long lat = Math.round(point.x * 1e5);
            long lng = Math.round(point.y * 1e5);

            long dLat = lat - lastLat;
            long dLng = lng - lastLng;

            encode(dLat, result);
            encode(dLng, result);

            lastLat = lat;
            lastLng = lng;
        }
        return result.toString();
    }

    private static void encode(long v, StringBuffer result) {
        v = v < 0 ? ~(v << 1) : v << 1;
        while (v >= 0x20) {
            result.append(Character.toChars((int) ((0x20 | (v & 0x1f)) + 63)));
            v >>= 5;
        }
        result.append(Character.toChars((int) (v + 63)));
    }

	@Override
	public String getURI() {
		return POSTGIS.ST_ASENCODEDPOLYLINE.stringValue();
	}

}
