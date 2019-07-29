package main.java.de.hsmainz.rdf4jpostgis.linestring;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import main.java.de.hsmainz.rdf4jpostgis.geometry.GeometricUnaryFunction;

public class EndPoint extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {
		if (geom instanceof LineString) {

            Point point = ((LineString) geom).getEndPoint();
            return point;
        }else if(geom instanceof Point) {
        	return geom;
        }
		return null;
	}

}
