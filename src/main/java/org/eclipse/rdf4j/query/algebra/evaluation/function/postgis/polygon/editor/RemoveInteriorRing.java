package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

/**
 * Removes an interior ring from a given polygon.
 */
public class RemoveInteriorRing extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_removeInteriorRing.toString();
	}

	@Override
	protected Geometry relation(Geometry geom, Double value) {
		if(geom instanceof Polygon) {
			Polygon poly=(Polygon) geom;
			List<LinearRing> rings=new LinkedList<LinearRing>();
			for(int i=0;i<poly.getNumInteriorRing();i++) {
				if(i!=value) {
					rings.add((LinearRing)poly.getInteriorRingN(i));
				}
			}
			GeometryFactory fac=new GeometryFactory();
			return fac.createPolygon((LinearRing)poly.getExteriorRing(), rings.toArray(new LinearRing[0]));
		}
		return null;
	}

}
