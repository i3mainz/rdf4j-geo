package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.overlay.snap.GeometrySnapper;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;

public class Snap extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_snap.stringValue();
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry g2) {
		GeometrySnapper snapper = new GeometrySnapper(g1);
        //Geometry snapGeom = snapper.snapTo(g2, tolerance);
		return null;
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
		// TODO Auto-generated method stub
		return null;
	}

}
