package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.editor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

/**
 * Sets the first point of the given geometry to the point given in the second parameter.
 *
 */
public class SetStartPoint extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setStartPoint.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
        if (geom2 instanceof Point) {
            Coordinate[] coords=geom1.getCoordinates();
            Coordinate[] newcoords=coords;
            newcoords[0]=geom2.getCoordinate();
            return LiteralUtils.createGeometry(newcoords, geom1.getGeometryType(), geom1.getSRID());
        }
        return null;
	}

}
