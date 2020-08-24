package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.transform;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

/**
 * Reverses the coordinates of a given ring of a polygon.
 */
public class ReverseRing extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_reverseRing.toString();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
		if(geom instanceof Polygon) {
			Polygon poly=(Polygon) geom;
			if(value<0 || value>poly.getNumInteriorRing()) {
				return geom;
			}
			List<LinearRing> rings=new LinkedList<LinearRing>();
			for(int i=0;i<poly.getNumInteriorRing();i++) {
				if(i==value) {
					List<Coordinate> newring=new LinkedList<Coordinate>();
					for(int j=poly.getInteriorRingN(i).getCoordinates().length-1;j>=0;j--) {
						newring.add(poly.getInteriorRingN(i).getCoordinateN(j));
					}
					GeometryFactory fac=new GeometryFactory();
					rings.add(fac.createLinearRing(newring.toArray(new Coordinate[0])));
				}else {
					rings.add((LinearRing)poly.getInteriorRingN(i));
				}
			}
			GeometryFactory fac=new GeometryFactory();
			return fac.createPolygon((LinearRing)poly.getExteriorRing(), rings.toArray(new LinearRing[0]));
		}
		return null;
	}

}
