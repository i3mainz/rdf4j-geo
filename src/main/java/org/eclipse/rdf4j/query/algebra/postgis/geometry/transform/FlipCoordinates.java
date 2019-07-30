package main.java.de.hsmainz.rdf4jpostgis.geometry.transform;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXYM;
import org.locationtech.jts.geom.CoordinateXYZM;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class FlipCoordinates extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_flipCoordinates.stringValue();
	}
	
	@Override
	protected Geometry operation(Geometry geom) {
            List<Coordinate> newcoords=new ArrayList<Coordinate>();
            	for(Coordinate coord:geom.getCoordinates()) {
            		if(coord instanceof CoordinateXYM) {
                		newcoords.add(new CoordinateXYM(coord.getY(),coord.getX(),coord.getM()));
            		}else if(coord instanceof CoordinateXYZM) {
            			newcoords.add(new CoordinateXYZM(coord.getY(),coord.getX(),coord.getZ(),coord.getM()));
            		}else {
                		newcoords.add(new Coordinate(coord.getX(),coord.getY()));            			
            		}
            	}
            return LiteralUtils.createGeometry(newcoords, geom.getGeometryType(), geom.getSRID());
	}
	
}
