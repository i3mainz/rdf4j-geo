package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import java.io.IOException;
import java.text.ParseException;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.JtsPolyshapeWriter;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.PolyshapeReader;
import org.locationtech.jts.geom.Geometry;

public class PolyshapeDatatype extends VectorLiteral {

    /**
     * The default WKT type URI.
     */
    public static final String URI = POSTGIS.Polyshape;

    /**
     * A static instance of WKTDatatype.
     */
    public static final PolyshapeDatatype INSTANCE = new PolyshapeDatatype();
    
    private static final PolyshapeReader reader=new PolyshapeReader();
    
    private static final JtsPolyshapeWriter writer=new JtsPolyshapeWriter();

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
            return writer.toString(geometry);           	
    }

    @Override
    public Geometry read(String geometryLiteral) {
    	try {
			return reader.read(geometryLiteral);
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
    }
}
