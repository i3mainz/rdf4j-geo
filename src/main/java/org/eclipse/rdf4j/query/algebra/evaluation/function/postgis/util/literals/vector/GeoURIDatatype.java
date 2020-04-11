package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class GeoURIDatatype extends VectorLiteral {

    /**
     * The default WKT type URI.
     */
    public static final String URI = POSTGIS.NAMESPACE+POSTGIS.GeoURI;

    /**
     * A static instance of WKTDatatype.
     */
    public static final GeoURIDatatype INSTANCE = new GeoURIDatatype();
    
    public static final IRI LiteralIRI=SimpleValueFactory.getInstance().createIRI(POSTGIS.NAMESPACE+POSTGIS.GeoURI);


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
