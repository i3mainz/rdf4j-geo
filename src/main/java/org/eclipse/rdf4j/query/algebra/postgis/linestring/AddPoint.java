package org.eclipse.rdf4j.query.algebra.postgis.linestring;

import java.util.Arrays;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricModifierFunction;

public class AddPoint extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ADDPOINT.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
		Coordinate[] coords=geom1.getCoordinates();
		GeometryFactory fac=new GeometryFactory();
        Point point = ((Point) geom2);
        List<Coordinate> newcoords=Arrays.asList(coords);
        newcoords.add(point.getCoordinate());
        return LiteralUtils.createGeometry(newcoords, geom1.getGeometryType(), geom1.getSRID());
    }

}
