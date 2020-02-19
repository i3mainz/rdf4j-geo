package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;

import com.conveyal.data.geobuf.GeobufDecoder;
import com.conveyal.data.geobuf.GeobufEncoder;

public class GeobufDatatype extends VectorLiteral  {

	    /**
	     * The default WKT type URI.
	     */
	    public static final String URI = POSTGIS.GeoBuf;

	    /**
	     * A static instance of WKTDatatype.
	     */
	    public static final GeobufDatatype INSTANCE = new GeobufDatatype();
	   

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
	            ByteArrayOutputStream output=new ByteArrayOutputStream();
	            GeobufEncoder enc=new GeobufEncoder(output,geometry.getPrecisionModel().getMaximumSignificantDigits());
	            return enc.geomToGeobuf(geometry).toString();
	    }

	    @Override
	    public Geometry read(String geometryLiteral) {
	    	InputStream stream = new ByteArrayInputStream(geometryLiteral.getBytes(StandardCharsets.UTF_8));
	    	GeobufDecoder decoder;
			try {
				decoder = new GeobufDecoder(stream);
		    	Geometry geom=decoder.next().geometry;
		    	return LiteralUtils.createGeometry(geom.getCoordinates(), geom.getGeometryType(), geom.getSRID());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
	    }


	    @Override
	    public String toString() {
	        return "GeoBufDatatype{" + URI + '}';
	    }

}

