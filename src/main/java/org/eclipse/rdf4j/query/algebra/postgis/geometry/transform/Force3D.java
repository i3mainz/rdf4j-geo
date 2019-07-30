package org.eclipse.rdf4j.query.algebra.postgis.geometry.transform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricUnaryFunction;


public class Force3D extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_force3d.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		List<Coordinate> newcoords=new ArrayList<Coordinate>();
        for(Coordinate coord:geom.getCoordinates()) {
        	newcoords.add(new Coordinate(coord.x,coord.y,Double.isNaN(coord.getZ())?0.:coord.getZ()));
        }         
         return LiteralUtils.createGeometry(newcoords,geom.getGeometryType(),geom.getSRID());           
	}

}
