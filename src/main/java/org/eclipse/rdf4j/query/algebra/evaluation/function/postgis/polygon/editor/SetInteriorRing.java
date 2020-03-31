package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierGeometryIntegerFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

public class SetInteriorRing extends GeometricModifierGeometryIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setInteriorRing.toString();
	}

	@Override
	protected Geometry relation(Geometry geom, Geometry geom2, Integer value) {
		if(geom instanceof Polygon) {
			Polygon poly=(Polygon) geom;
			List<LinearRing> rings=new LinkedList<LinearRing>();
			for(int i=0;i<poly.getNumInteriorRing();i++) {
				if(i==value) {
					rings.add((LinearRing)geom2);
				}
			}
			GeometryFactory fac=new GeometryFactory();
			return fac.createPolygon((LinearRing)poly.getExteriorRing(), rings.toArray(new LinearRing[0]));
		}
		return null;
	}

}
