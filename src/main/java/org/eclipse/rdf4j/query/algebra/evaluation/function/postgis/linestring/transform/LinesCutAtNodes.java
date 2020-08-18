package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.geom.Point;

public class LinesCutAtNodes extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_linesCutAtNodes.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Geometry g2) {
		if(g2 instanceof Point) {
			
		}else if(g2 instanceof MultiPoint) {
			
		}
         return null;
	}

}
