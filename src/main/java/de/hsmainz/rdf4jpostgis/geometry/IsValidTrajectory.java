package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.apache.jena.sparql.expr.NodeValue;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;

public class IsValidTrajectory extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		if (geom instanceof LineString) {
			Double lastM = Double.MIN_VALUE;
			for (Coordinate coord : geom.getCoordinates()) {
				if (Double.isNaN(coord.getM()) || coord.getM() <= lastM) {
					return false;
				} else {
					lastM = coord.getM();
				}
			}
			return true;
		}
		return false;
	}
	

}
