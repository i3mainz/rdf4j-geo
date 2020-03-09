package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public class DissolvePoints extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_dissolvepoints.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		GeometryFactory fac=new GeometryFactory();
        List<Point> res=new LinkedList<Point>();
        for(Coordinate coord:geom.getCoordinates()) {
        	res.add(fac.createPoint(coord));
        }
        return fac.createMultiPoint(geom.getCoordinates());
	}

}
