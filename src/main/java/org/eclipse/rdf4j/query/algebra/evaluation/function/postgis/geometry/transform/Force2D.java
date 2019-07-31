package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;


public class Force2D extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_force2d.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
        List<Coordinate> newcoords=new ArrayList<Coordinate>();
        for(Coordinate coord:geom.getCoordinates()) {
        	newcoords.add(new Coordinate(coord.x,coord.y));
        }
        return LiteralUtils.createGeometry(newcoords,geom.getGeometryType(),geom.getSRID());   
	}

}
