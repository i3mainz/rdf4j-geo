package main.java.de.hsmainz.rdf4jpostgis.geometry;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXYM;
import org.locationtech.jts.geom.Geometry;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;


public class Force3DM extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {
        List<Coordinate> newcoords=new ArrayList<Coordinate>();
        for(Coordinate coord:geom.getCoordinates()) {
        	newcoords.add(new CoordinateXYM(coord.x,coord.y,Double.isNaN(coord.getM())?0.:coord.getM()));
        }         
        return LiteralUtils.createGeometry(newcoords,geom.getGeometryType(),geom.getSRID());   
	}

}
