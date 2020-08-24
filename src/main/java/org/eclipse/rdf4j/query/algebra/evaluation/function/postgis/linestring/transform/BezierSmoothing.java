package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
//import org.jaitools.jts.LineSmoother;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;

public class BezierSmoothing extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_BEZIERSMOOTHING.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double alpha) {
		return null;
		//LineSmoother smoother=new LineSmoother();
		//return smoother.smooth(((LineString)geom), alpha);
	}

}
