package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import java.io.IOException;
import java.text.ParseException;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.hsmainz.cs.semgis.arqextension.util.JtsPolyshapeWriter;
import de.hsmainz.cs.semgis.arqextension.util.PolyshapeReader;
import de.hsmainz.cs.semgis.arqextension.util.PolyshapeWriter;
import de.hsmainz.cs.semgis.arqextension.vocabulary.PostGISGeo;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;

public class PolyshapeDatatype extends VectorLiteral {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncodedPolylineDatatype.class);

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
	    GeometryWrapper wrapper;
		try {
			wrapper = GeometryWrapperFactory.createGeometry(reader.read(geometryLiteral), "<http://www.opengis.net/def/crs/EPSG/0/4326>", PolyshapeDatatype.URI);
			return wrapper;
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
    }
}
