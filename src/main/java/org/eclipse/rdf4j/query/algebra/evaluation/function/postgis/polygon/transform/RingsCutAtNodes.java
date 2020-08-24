package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.transform;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;

public class RingsCutAtNodes extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_ringsCutAtNodes.toString();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		/*if(geom instanceof Polygon) {
			Polygon poly=(Polygon) geom;
			List<LinearRing> rings=new LinkedList<LinearRing>();
			for(int i=0;i<poly.getNumInteriorRing();i++) {
				if(i==value) {
					rings.add((LinearRing) poly.getInteriorRingN(i).reverse());
				}else {
					rings.add((LinearRing)poly.getInteriorRingN(i));
				}
			}
			GeometryFactory fac=new GeometryFactory();
			return fac.createPolygon((LinearRing)poly.getExteriorRing(), rings.toArray(new LinearRing[0]));
		}*/
		return null;
	}
	
}
