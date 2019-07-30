package org.eclipse.rdf4j.query.algebra.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.overlay.snap.GeometrySnapper;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricModifierFunction;

public class Snap extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_snap.stringValue();
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry g2) {
		GeometrySnapper snapper = new GeometrySnapper(g1));
        Geometry snapGeom = snapper.snapTo(g2, tolerance);

	}

}
