package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

public class Zmflag extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
	            Coordinate coord=geom.getCoordinates()[0];
	            if(Double.isNaN(coord.getM()) && Double.isNaN(coord.getZ())) {
	            	return "0";
	            }else if(!Double.isNaN(coord.getM()) && Double.isNaN(coord.getZ())) {
	            	return "1";
	            }else if(Double.isNaN(coord.getM()) && !Double.isNaN(coord.getZ())) {
	            	return "2";
	            }else if(!Double.isNaN(coord.getM()) && !Double.isNaN(coord.getZ())) {
	            	return "3";
	            }
	            return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_zmFlag.stringValue();
	}

}
