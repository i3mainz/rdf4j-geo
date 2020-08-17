package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.attribute;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class HasSelfIntersections extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_hasSelfIntersections.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
    	Set<Coordinate> coords=new HashSet<Coordinate>();
    	List<Coordinate> results=new LinkedList<Coordinate>();
    	for(Coordinate coord:geom.getCoordinates()) {
    		if(coords.contains(coord)) {
    			results.add(coord);
    		}
    		coords.add(coord);
    	}
    	if(results.isEmpty()) {
    		return false;
    	}
    	return true;
	}

}
