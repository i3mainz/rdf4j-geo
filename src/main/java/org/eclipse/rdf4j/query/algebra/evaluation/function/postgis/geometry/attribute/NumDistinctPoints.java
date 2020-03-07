package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;
import org.locationtech.jts.geom.Geometry;

public class NumDistinctPoints extends GeometricIntegerAttributeFunction {

		@Override
		public String getURI() {
			return POSTGIS.st_numdistinctPoints.stringValue();
		}

		@Override
		public int attribute(Geometry geom) {
			return geom.getNumPoints();
		}

	}
