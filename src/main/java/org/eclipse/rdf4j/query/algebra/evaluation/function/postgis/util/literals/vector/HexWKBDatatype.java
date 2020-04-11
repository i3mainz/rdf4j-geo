package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;


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
public class HexWKBDatatype extends VectorLiteral {

    /**
     * The default WKT type URI.
     */
    public static final String URI = POSTGIS.NAMESPACE+POSTGIS.HEXWKB;

    /**
     * A static instance of WKTDatatype.
     */
    public static final HexWKBDatatype INSTANCE = new HexWKBDatatype();
    
	public static final IRI LiteralIRI=SimpleValueFactory.getInstance().createIRI(POSTGIS.NAMESPACE+POSTGIS.HEXWKB);


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
            WKBWriter writer=new WKBWriter();
            return WKBWriter.toHex(writer.write(geometry)).toString();
    }

    @Override
    public Geometry read(String geometryLiteral) {
        HexWKBTextSRS wkbTextSRS = new HexWKBTextSRS(geometryLiteral);
        WKBReader wkbReader = new WKBReader();
        Geometry geometry=null;
			try {
				geometry = wkbReader.read(WKBReader.hexToBytes(wkbTextSRS.getWkbText().toString()));
				return geometry;
			} catch (ParseException e) {
				throw new RuntimeException(e.getMessage());
			}
    }

    private class HexWKBTextSRS {

        private final String wkbText;
        private final String srsURI;

        public HexWKBTextSRS(String wkbLiteral) {
            int startSRS = wkbLiteral.indexOf("<");
            int endSRS = wkbLiteral.indexOf(">");

            //Check that both chevrons are located and extract SRS_URI name, otherwise default.
            if (startSRS != -1 && endSRS != -1) {
                srsURI = wkbLiteral.substring(startSRS + 1, endSRS);
                wkbText = wkbLiteral.substring(endSRS + 1);

            } else {
                srsURI = "<http://www.opengis.net/def/crs/OGC/1.3/CRS84>";
                wkbText = wkbLiteral;
            }
        }

        public String getWkbText() {
            return wkbText;
        }

        public String getSrsURI() {
            return srsURI;
        }

    }

    @Override
    public String toString() {
        return "HexWKBDatatype{" + URI + '}';
    }

}

