package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class YMax extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_yMax.stringValue();
	}
	
	@Override
	public double attribute(Geometry geom) {
        Geometry geo=geom;
        Double maxY=0.;
        for(Coordinate coord:geo.getCoordinates()) {
        	if(maxY<coord.getY()) {
        		maxY=coord.getY();
        	}
        }
        return maxY;
	}

}
