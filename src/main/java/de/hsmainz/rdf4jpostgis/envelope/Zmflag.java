package main.java.de.hsmainz.rdf4jpostgis.envelope;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.apache.jena.sparql.expr.NodeValue;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;

public class Zmflag extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
	            Coordinate coord=geom.getCoordinates()[0];
	            if(Double.isNaN(coord.getM()) && Double.isNaN(coord.getZ())) {
	            	return 0;
	            }else if(!Double.isNaN(coord.getM()) && Double.isNaN(coord.getZ())) {
	            	return 1;
	            }else if(Double.isNaN(coord.getM()) && !Double.isNaN(coord.getZ())) {
	            	return 2;
	            }else if(!Double.isNaN(coord.getM()) && !Double.isNaN(coord.getZ())) {
	            	return 3;
	            }
	            return null;
	}

}
