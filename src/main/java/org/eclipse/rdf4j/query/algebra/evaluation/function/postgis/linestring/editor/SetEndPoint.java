package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.editor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

public class SetEndPoint extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setEndPoint.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
		Geometry transformed=LiteralUtils.transform(geom2, geom1);
        if (geom1 instanceof LineString && transformed instanceof Point) {
            Coordinate[] coords=geom1.getCoordinates();
            Coordinate[] newcoords=coords;
            newcoords[newcoords.length-1]=geom2.getCoordinate();
            return LiteralUtils.createGeometry(newcoords, geom1.getGeometryType(), geom1.getSRID());
        }
        return null;
	}

}