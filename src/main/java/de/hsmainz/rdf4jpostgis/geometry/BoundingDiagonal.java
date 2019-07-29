package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class BoundingDiagonal extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {
		 org.locationtech.jts.geom.Envelope env=geom.getEnvelopeInternal();
         Coordinate lowerCorner=new Coordinate(env.getMinX(),env.getMinY());
         Coordinate upperCorner=new Coordinate(env.getMaxX(),env.getMaxY());
         GeometryFactory fac=new GeometryFactory();
         return fac.createLineString(new Coordinate[] {lowerCorner,upperCorner});    
	}

}
