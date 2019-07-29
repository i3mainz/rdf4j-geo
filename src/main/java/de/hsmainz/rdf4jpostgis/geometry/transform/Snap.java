package main.java.de.hsmainz.rdf4jpostgis.geometry.transform;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.overlay.snap.GeometrySnapper;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierFunction;

public class Snap extends GeometricModifierFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry g2) {
		GeometrySnapper snapper = new GeometrySnapper(g1));
        Geometry snapGeom = snapper.snapTo(g2, tolerance);

	}

}
