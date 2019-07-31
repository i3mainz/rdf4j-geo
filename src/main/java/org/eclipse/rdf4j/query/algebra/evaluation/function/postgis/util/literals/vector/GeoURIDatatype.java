package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeoURIDatatype extends VectorLiteral {

	private static final Logger LOGGER = LoggerFactory.getLogger(GeoURIDatatype.class);

    /**
     * The default WKT type URI.
     */
    public static final String URI = POSTGIS.GeoURI;

    /**
     * A static instance of WKTDatatype.
     */
    public static final GeoURIDatatype INSTANCE = new GeoURIDatatype();

	@Override
	public Geometry read(String geometryLiteral) {
		String[] items=geometryLiteral.split(";");
		if(items.length==0 || items.length>4) {
			throw new AssertionError("Not a valid geoURI: " + geometryLiteral);
		}
		String[] coordinates=items[0].replace("geo:", "").split(",");
		GeometryFactory fac=new GeometryFactory();
		return fac.createPoint(new Coordinate(Double.valueOf(coordinates[0]),Double.valueOf(coordinates[1])));
	}
	
	@Override
	public String unparse(Geometry geom) {
            if("POINT".equalsIgnoreCase(geom.getGeometryType())) {
            	return "geo:"+geom.getCoordinate().x+","+geom.getCoordinate().y+";crs=EPSG:"+geom.getSRID();
            }
            return "geo:"+geom.getCentroid().getCoordinate().x+","+geom.getCentroid().getCoordinate().y+";crs=EPSG:"+geom.getSRID();	
	}
    
    

}
