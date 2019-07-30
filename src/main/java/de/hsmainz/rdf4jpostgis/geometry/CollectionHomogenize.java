package main.java.de.hsmainz.rdf4jpostgis.geometry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class CollectionHomogenize extends GeometricUnaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.ST_COLLECTIONHOMOGENIZE.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
         GeometryCollection collection=(GeometryCollection)geom;
         GeometryFactory fac=new GeometryFactory();
         if(collection.getNumGeometries()==1) {
         	Geometry singlegeom=collection.getGeometryN(0);
         	return LiteralUtils.fac.createGeometry(singlegeom, "<http://www.opengis.net/def/crs/EPSG/0/"+collection.getSRID()+">", WKTDatatype.URI).asNodeValue();           	
         }else if(collection.getNumGeometries()==0) {
         	return geom1.asNodeValue();
         }else {
         	switch(collection.getGeometryN(0).getGeometryType()) {
             case "Point":
             	List<Coordinate> coords=new ArrayList<Coordinate>();
             	for(int i=0;i<collection.getNumGeometries();i++) {
             		for(Coordinate coord2:collection.getGeometryN(i).getCoordinates()) {
             			coords.add(coord2);
             		}
             	}
             	GeometryWrapper pointWrapper = GeometryWrapperFactory.createMultiPoint(coords, "<http://www.opengis.net/def/crs/EPSG/0/"+geom1.getSRID()+">", WKTDatatype.URI);	
                 return pointWrapper.asNodeValue();
             case "LineString":
             	List<LineString> lines=new ArrayList<LineString>();
             	for(int i=0;i<collection.getNumGeometries();i++) {
             			lines.add((LineString)collection.getGeometryN(i));
             	}
             	GeometryWrapper lineWrapper = GeometryWrapperFactory.createMultiLineString(lines, "<http://www.opengis.net/def/crs/EPSG/0/"+geom1.getSRID()+">", WKTDatatype.URI);	
             	return lineWrapper.asNodeValue();
             case "Polygon": 
             	List<Polygon> polys=new ArrayList<Polygon>();
             	for(int i=0;i<collection.getNumGeometries();i++) {
             			polys.add((Polygon)collection.getGeometryN(i));
             	}
             	GeometryWrapper polyWrapper = GeometryWrapperFactory.createMultiPolygon(polys, "<http://www.opengis.net/def/crs/EPSG/0/"+geom1.getSRID()+">", WKTDatatype.URI);	
                 return polyWrapper.asNodeValue();
         	}
         }
	}

}
