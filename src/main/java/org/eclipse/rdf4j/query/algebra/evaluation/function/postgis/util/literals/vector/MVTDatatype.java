package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import org.apache.solr.common.util.Base64;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.parsers.VectorTileDecoder;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.parsers.VectorTileDecoder.Feature;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.parsers.VectorTileDecoder.FeatureIterable;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.parsers.VectorTileEncoder;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.GeometryFactory;

public class MVTDatatype extends VectorLiteral {

    /**
     * The default GML type URI.
     */
    public static final String URI = POSTGIS.MVT;

    /**
     * A static instance of GMLDatatype.
     */
    public static final MVTDatatype INSTANCE = new MVTDatatype();

    /**
     * XML element tag "gml" is defined for the convenience of GML generation.
     */
    public static final String KML_PREFIX = "mvt";

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
    	VectorTileEncoder encoder = new VectorTileEncoder();
    	encoder.addFeature("mvt", new TreeMap<>(), geometry);
    	// Finally, get the byte array
    	byte[] encoded = encoder.encode();
    	return new String(Base64.byteArrayToBase64(encoded));
    }

    @Override
    public Geometry read(String geometryLiteral) {
    	VectorTileDecoder decoder=new VectorTileDecoder();
    	FeatureIterable res;
		try {
			res = decoder.decode(Base64.base64ToByteArray(geometryLiteral));
		
    	Iterator<Feature> it=res.iterator();
    	GeometryFactory fac=new GeometryFactory();
    	List<Geometry> geoms=new LinkedList<Geometry>();
    	while(it.hasNext()) {
    		Feature feat=it.next();
    		geoms.add(feat.getGeometry());
    	}
    	if(geoms.isEmpty()) {
    		return fac.createGeometry(null);
    	}
    	if(geoms.size()==1) {
    		return geoms.get(0);
    	}
    	return new GeometryCollection(geoms.toArray(new Geometry[geoms.size()]),fac);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public String toString() {
        return "KMLDatatype{" + URI + '}';
    }

}
