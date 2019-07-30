package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXY;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierIntegerFunction;

public class PointN extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_pointN.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
        Coordinate[] coords = geom.getCoordinates();
        CoordinateXY coord = new CoordinateXY(coords[value].x, coords[value].y);
        GeometryFactory fac=new GeometryFactory();
        return fac.createPoint(coord);
	}

}
