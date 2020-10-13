package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;

public class CollectionExtract extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_collectionextract.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer type) {
	    GeometryFactory fac=new GeometryFactory();
        GeometryCollection collection=(GeometryCollection)geom;
        switch(type) {
        case 1:
        	List<Coordinate> coords=new ArrayList<Coordinate>();
        	for(int i=0;i<collection.getNumGeometries();i++) {
        		for(Coordinate coord2:collection.getGeometryN(i).getCoordinates()) {
        			coords.add(coord2);
        		}
        	}
        	if(coords.size()==1) {
        		return fac.createPoint(coords.get(0));
        	}
         	return fac.createMultiPointFromCoords(coords.toArray(new Coordinate[0]));
        case 2:
        	List<LineString> lines=new ArrayList<LineString>();
        	for(int i=0;i<collection.getNumGeometries();i++) {
        			lines.add((LineString)collection.getGeometryN(i));
        	}
         	return fac.createMultiLineString(lines.toArray(new LineString[0]));
        case 3: 
        	List<Polygon> polys=new ArrayList<Polygon>();
        	for(int i=0;i<collection.getNumGeometries();i++) {
        			polys.add((Polygon)collection.getGeometryN(i));
        	}
         	return fac.createMultiPolygon(polys.toArray(new Polygon[0]));
        }
        return null;
	}

}
