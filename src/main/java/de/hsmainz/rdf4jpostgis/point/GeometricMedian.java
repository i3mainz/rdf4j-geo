package main.java.de.hsmainz.rdf4jpostgis.point;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class GeometricMedian extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {
	    Coordinate median=getGeoMedian(geom.getCentroid().getCoordinate(), geom.getCoordinates());
	    GeometryFactory fac=new GeometryFactory();
	    return fac.createPoint(median);
	}
	



public Coordinate getGeoMedian(Coordinate start,Coordinate[] points) {
    double cx = 0;
    double cy = 0;

    double centroidx = start.x;
    double centroidy = start.y;
    do {
        double totalWeight = 0;
        for (int i = 0; i < points.length; i++) {
            Coordinate pt = points[i];
            double weight = 1 / distance(pt.x, pt.y, centroidx, centroidy);
            cx += pt.x * weight;
            cy += pt.y * weight;
            totalWeight += weight;
        }
        cx /= totalWeight;
        cy /= totalWeight;
    } while (Math.abs(cx - centroidx) > 0.5
            || Math.abs(cy - centroidy) > 0.5);// Probably this condition
                                                // needs to change

    return new Coordinate(cx, cy);
}

private static double distance(double x1, double y1, double x2, double y2) {
    x1 -= x2;
    y1 -= y2;
    return Math.sqrt(x1 * x1 + y1 * y1);
}

}
