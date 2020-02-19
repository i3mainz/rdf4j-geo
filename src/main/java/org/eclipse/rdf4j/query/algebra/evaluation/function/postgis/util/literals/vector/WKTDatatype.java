package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.io.WKTWriter;

public class WKTDatatype extends VectorLiteral {

    /**
     * The default WKT type URI.
     */
    public static final String URI = POSTGIS.NAMESPACE+POSTGIS.WKT.toLowerCase()+"Literal";

    /**
     * A static instance of WKTDatatype.
     */
    public static final WKTDatatype INSTANCE = new WKTDatatype();

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
            WKTWriter writer=new WKTWriter();
            return writer.write(geometry).toString();
    }

    @Override
    public Geometry read(String geometryLiteral) {
        WKBTextSRS wkbTextSRS = new WKBTextSRS(geometryLiteral);

        WKTReader wkbReader = new WKTReader();
        Geometry geometry;
		try {
			geometry = wkbReader.read(wkbTextSRS.getWkbText());
			return geometry;
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}


    }

    private class WKBTextSRS {

        private final String wkbText;
        private final String srsURI;

        public WKBTextSRS(String wkbLiteral) {
            int startSRS = wkbLiteral.indexOf("<");
            int endSRS = wkbLiteral.indexOf(">");

            //Check that both chevrons are located and extract SRS_URI name, otherwise default.
            if (startSRS != -1 && endSRS != -1) {
                srsURI = wkbLiteral.substring(startSRS + 1, endSRS);
                wkbText = wkbLiteral.substring(endSRS + 1);

            } else {
                srsURI = "";//SRS_URI.DEFAULT_WKT_CRS84;
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
        return "WKTDatatype{" + URI + '}';
    }

}
