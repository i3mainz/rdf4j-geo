package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.kml.KMLWriter;

/**
 *
 *
 *
 */
public class KMLDatatype extends VectorLiteral {

    /**
     * The default GML type URI.
     */
    public static final String URI = POSTGIS.KML;

    /**
     * A static instance of GMLDatatype.
     */
    public static final KMLDatatype INSTANCE = new KMLDatatype();

    /**
     * XML element tag "gml" is defined for the convenience of GML generation.
     */
    public static final String KML_PREFIX = "kml";

    /**
     * This method Un-parses the JTS Geometry to the GML literal
     *
     * @param geometry - the JTS Geometry to be un-parsed
     * @return GML - the returned GML Literal.
     * <br> Notice that the Spatial Reference System
     * "urn:ogc:def:crs:OGC::CRS84" is predefined in the returned GML literal.
     */
    @Override
    public String unparse(Geometry geometry) {
            KMLWriter writer=new KMLWriter();
            return writer.write(geometry);
    }

    @Override
    public Geometry read(String geometryLiteral) {
        /*try {
            KmlReader kmlReader = KmlReader(geometryLiteral);
            kmlReader.
            kmlReader.rea.extract(geometryLiteral);
            Geometry geometry = kmlReader.getGeometry();
            DimensionInfo dimensionInfo = kmlReader.getDimensionInfo();

            return new GeometryWrapper(geometry, kmlReader.getSrsName(), URI, dimensionInfo, geometryLiteral);
        } catch (JDOMException | IOException ex) {
            throw new DatatypeFormatException("Illegal KML literal:" + geometryLiteral + ". " + ex.getMessage());
        }*/
    	return null;
    }

    @Override
    public String toString() {
        return "KMLDatatype{" + URI + '}';
    }

}

