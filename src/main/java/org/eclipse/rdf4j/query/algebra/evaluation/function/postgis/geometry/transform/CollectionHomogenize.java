package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

public class CollectionHomogenize extends GeometricUnaryFunction {
	

	@Override
	public String getURI() {
		return POSTGIS.ST_COLLECTIONHOMOGENIZE.stringValue();
	}
	@Override
	protected Geometry operation(Geometry collection) {
	     GeometryFactory fac=new GeometryFactory();
		 if(collection.getNumGeometries()==1) {
	     	Geometry singlegeom=collection.getGeometryN(0);
	     	return singlegeom;
	     }else if(collection.getNumGeometries()==0) {
	     	return collection;
	     }else {
	     	switch(collection.getGeometryN(0).getGeometryType()) {
	         case "Point":
	         	List<Coordinate> coords=new ArrayList<Coordinate>();
	         	for(int i=0;i<collection.getNumGeometries();i++) {
	         		for(Coordinate coord2:collection.getGeometryN(i).getCoordinates()) {
	         			coords.add(coord2);
	         		}
	         	}
	         	return fac.createMultiPointFromCoords(coords.toArray(new Coordinate[0]));
	         case "LineString":
	         	List<LineString> lines=new ArrayList<LineString>();
	         	for(int i=0;i<collection.getNumGeometries();i++) {
	         			lines.add((LineString)collection.getGeometryN(i));
	         	}
	         	return fac.createMultiLineString(lines.toArray(new LineString[0]));
	         case "Polygon": 
	         	List<Polygon> polys=new ArrayList<Polygon>();
	         	for(int i=0;i<collection.getNumGeometries();i++) {
	         			polys.add((Polygon)collection.getGeometryN(i));
	         	}
	         	return fac.createMultiPolygon(polys.toArray(new Polygon[0]));
	     	}
	     }
		 return null;
	}

}
