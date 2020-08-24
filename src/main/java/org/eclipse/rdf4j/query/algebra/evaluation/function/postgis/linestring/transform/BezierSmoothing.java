package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.jaitools.jts.LineSmoother;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;

public class BezierSmoothing extends GeometricModifierDoubleFunction{

	@Override
	public String getURI() {
		return POSTGIS.ST_BEZIERSMOOTHING.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double alpha) {
		LineSmoother smoother=new LineSmoother();
		return smoother.smooth(((LineString)geom.getXYGeometry()), alpha);

	}
	

}
