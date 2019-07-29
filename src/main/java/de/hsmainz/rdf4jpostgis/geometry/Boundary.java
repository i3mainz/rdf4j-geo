package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.BoundaryOp;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class Boundary extends GeometricUnaryFunction{

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {
        BoundaryOp boundop=new BoundaryOp(geom);
        return boundop.getBoundary();     
	}

}
