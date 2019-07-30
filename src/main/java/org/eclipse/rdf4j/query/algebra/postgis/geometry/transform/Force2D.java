package main.java.de.hsmainz.rdf4jpostgis.geometry.transform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;


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
