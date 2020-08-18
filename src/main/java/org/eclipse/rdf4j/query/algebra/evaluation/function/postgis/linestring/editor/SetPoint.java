package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.editor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleModifierIntegerFunction;


public class SetPoint extends GeometricDoubleModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setPoint.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2,Integer zerobasedposition) {
        if (geom2 instanceof Point) {
            Coordinate[] coords=geom1.getCoordinates();
            Coordinate[] newcoords=coords;
            newcoords[zerobasedposition.intValue()]=geom2.getCoordinate();
            return LiteralUtils.createGeometry(newcoords, geom1.getGeometryType(), geom1.getSRID());
        }
        return null;
	}

}
