package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationIntegerFunction;
import org.locationtech.jts.geom.Geometry;

public class LineCrossingDirection extends GeometricRelationIntegerFunction {

		@Override
		public String getURI() {
			return POSTGIS.st_lineCrossingDirection.stringValue();
		}
		
		@Override
		protected int relation(Geometry g1, Geometry g2) {
			if(!g1.intersects(g2)) {
				return 0;
			}
			return -4;
		}
	
}
