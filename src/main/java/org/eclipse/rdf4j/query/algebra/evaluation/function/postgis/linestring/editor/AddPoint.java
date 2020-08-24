package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.editor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;

/**
 * Adds geometry two (a point geometry) to geometry one at the last position of the coordinate array.
 */
public class AddPoint extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ADDPOINT.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
		Coordinate[] coords=geom1.getCoordinates();
        Point point = ((Point) geom2);
        List<Coordinate> newcoords=new LinkedList<Coordinate>();
        for(int i=0;i<coords.length;i++) {
        	newcoords.add(coords[i]);
        }
        System.out.println(newcoords);
        newcoords.add(point.getCoordinate());
        return LiteralUtils.createGeometry(newcoords, geom1.getGeometryType(), geom1.getSRID());
    }

}
