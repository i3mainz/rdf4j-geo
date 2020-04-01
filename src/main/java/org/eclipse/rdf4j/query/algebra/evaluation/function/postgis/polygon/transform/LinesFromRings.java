package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.transform;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;

public class LinesFromRings extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_reverseRing.toString();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		if(geom instanceof Polygon || geom instanceof MultiPolygon) {
			Polygon poly=(Polygon) geom;
			List<LineString> rings=new LinkedList<LineString>();
			for(int i=0;i<poly.getNumInteriorRing();i++) {
				rings.add((LineString)poly.getInteriorRingN(i));
			}
			GeometryFactory fac=new GeometryFactory();
			return fac.createMultiLineString(rings.toArray(new LineString[0]));
		}
		return null;
	}

}
