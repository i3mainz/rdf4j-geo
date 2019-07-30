package main.java.de.hsmainz.rdf4jpostgis.linestring;

import java.util.Arrays;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierFunction;

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
