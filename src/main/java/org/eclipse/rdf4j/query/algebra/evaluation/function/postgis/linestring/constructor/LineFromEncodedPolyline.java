package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.constructor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;

/**
 * Creates a LineString from the encoded polyline format.
 */
public class LineFromEncodedPolyline extends GeometricConstructor {

	@Override
	public Geometry construct(String input) {
		GeometryFactory fac=new GeometryFactory();
		LineString ls=fac.createLineString(decodePolyline(input, 1).toArray(new Coordinate[0]));
		return ls;
	}
	
	/**
	 * Decodes a polyline with a given precision.
	 * @param polyline the polyline String to decode
	 * @param precision the precision used for decoding
	 * @return the list of coordinates which have been decoded
	 */
	public static List<Coordinate> decodePolyline(String polyline, int precision)
    {
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        int index = 0, shift, result;
        int byte_;
        int lat = 0, lng = 0, latitude_change, longitude_change,
            factor = (int) Math.pow(10, precision);

        while (index < polyline.length()) {
            byte_ = 0;
            shift = 0;
            result = 0;

            do {
                byte_ = polyline.charAt(index++) - 63;
                result |= (byte_ & 0x1f) << shift;
                shift += 5;
            } while (byte_ >= 0x20);

            latitude_change = ((result % 2 == 1) ? ~(result >> 1) : (result >> 1));

            shift = result = 0;

            do {
                byte_ = polyline.charAt(index++) - 63;
                result |= (byte_ & 0x1f) << shift;
                shift += 5;
            } while (byte_ >= 0x20);

            longitude_change = ((result % 2 == 1) ? ~(result >> 1) : (result >> 1));

            lat += latitude_change;
            lng += longitude_change;

            coordinates.add(new Coordinate((double)lat / factor,(double)lng / factor));
        }

        return coordinates;
    }

	@Override
	public String getURI() {
		return POSTGIS.st_lineFromEncodedPolyline.stringValue();
	}

}
