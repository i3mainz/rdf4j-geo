package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * WKTDatatype class allows the URI "geo:wktLiteral" to be used as a datatype
 * and it will parse that datatype to a JTS Geometry.
 *
 * Req 10 All RDFS Literals of type geo:wktLiteral shall consist of an optional
 * URI identifying the coordinate reference system followed by Simple Features
 * Well Known Text (WKT) describing a geometric value. Valid geo:wktLiterals are
 * formed by concatenating a valid, absolute URI as defined in [RFC 2396], one
 * or more spaces (Unicode U+0020 character) as a separator, and a WKT string as
 * defined in Simple Features [ISO 19125-1].
 *
 * Req 11 The URI {@code <http://www.opengis.net/def/crs/OGC/1.3/CRS84>} shall
 * be assumed as the spatial reference system for geo:wktLiterals that do not *
 * specify an explicit spatial reference system URI.
 */
public class EncodedPolylineDatatype extends VectorLiteral {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncodedPolylineDatatype.class);

    /**
     * The default WKT type URI.
     */
    public static final String URI = POSTGIS.EncodedPolyline;

    /**
     * A static instance of WKTDatatype.
     */
    public static final EncodedPolylineDatatype INSTANCE = new EncodedPolylineDatatype();

    /**
     * This method Un-parses the JTS Geometry to the WKT literal
     *
     * @param geometry - the JTS Geometry to be un-parsed
     * @return WKT - the returned WKT Literal.
     * <br> Notice that the Spatial Reference System is not specified in
     * returned WKT literal.
     *
     */
    @Override
    public String unparse(Geometry geometry) {
            if(geometry.getGeometryType().equals("LineString")){
                return encodePolyline((LineString)geometry);            	
            }else {
                throw new AssertionError("Object passed to EncodedPolylineDatatype is not a LineString: " + geometry);
            }
    }

    @Override
    public Geometry read(String geometryLiteral) {
    	GeometryFactory fac=new GeometryFactory();
    	return fac.createLineString(decodePolyline(geometryLiteral, 5).toArray(new Coordinate[0]));
    }
    
	/**
     * Encodes a sequence of LatLngs into an encoded path string.
     * Modified from https://gitlab.com/aceperry/androidmapsutil
     * Apache License 2.0
     */
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

 // Code from: https://gist.github.com/anirban-metal/2c530eefe9ddea026da04c845c13676a
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
    public String toString() {
        return "EncodedPolylineDatatype{" + URI + '}';
    }

}

