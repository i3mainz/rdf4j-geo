package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.attribute;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class SelfIntersections extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_selfIntersections.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
    	Set<Coordinate> coords=new HashSet<Coordinate>();
    	List<Coordinate> results=new LinkedList<Coordinate>();
    	for(Coordinate coord:geom.getCoordinates()) {
    		if(coords.contains(coord)) {
    			results.add(coord);
    		}
    		coords.add(coord);
    	}
    	GeometryFactory fac=new GeometryFactory();
    	return fac.createMultiPoint(results.toArray(new Coordinate[0]));
	}
}
