package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class LineSelfIntersectionPoint extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_lineSelfIntersectionPoint.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
        GeometryFactory fac=new GeometryFactory();    
		if(geom.isSimple()) {
            	return fac.createPoint();
            }else {
            	return LiteralUtils.createGeometry(geom.intersection(geom).getCoordinates(), "POINT", geom.getSRID());
            }
	}

}
