package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon;

import java.util.Arrays;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.algorithm.Orientation;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

/**
 * Orients all exterior rings clockwise and all interior rings counter-clockwise. 
 *
 */
public class ForcePolygonCW extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_forcePolygonCW.toString();
	}

	@Override
	protected Geometry operation(Geometry geom) {
            if (geom instanceof Polygon) {
            	if(!Orientation.isCCW(geom.getCoordinates())) {
            		return geom;
            	}else {
            		return LiteralUtils.createGeometry(Arrays.asList(geom.reverse().getCoordinates()), "Polygon", geom.getSRID());
            	}
            }
            return null;
	}

}
