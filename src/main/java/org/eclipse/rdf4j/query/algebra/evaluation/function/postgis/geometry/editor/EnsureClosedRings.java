package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

public class EnsureClosedRings extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_ensureClosedRings.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double value) {
		if(geom instanceof Polygon) {
			GeometryFactory fac=new GeometryFactory();

			Polygon poly=(Polygon) geom;
			List<LinearRing> rings=new LinkedList<LinearRing>();
			for(int i=0;i<poly.getNumInteriorRing();i++) {
				if(!poly.getInteriorRingN(i).isClosed()) {
					LinearRing ring=(LinearRing)poly.getInteriorRingN(i);
					List<Coordinate> coords=new LinkedList<Coordinate>();
					for(Coordinate coord:ring.getCoordinates()) {
						coords.add(coord);
					}
					coords.add(ring.getCoordinates()[0]);
					rings.add(fac.createLinearRing(coords.toArray(new Coordinate[0])));
				}else {
					rings.add((LinearRing)poly.getInteriorRingN(i));
				}
			}
		}
        return null;
	}

}
