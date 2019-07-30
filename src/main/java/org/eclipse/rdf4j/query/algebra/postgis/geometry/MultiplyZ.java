package main.java.de.hsmainz.rdf4jpostgis.geometry;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXYZM;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierDoubleFunction;

public class MultiplyZ extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_multiplyz.stringValue();
	}


	@Override
	protected Geometry relation(Geometry geom, Double value) {
        Double factor=value;
        List<Coordinate> newcoords=new LinkedList<Coordinate>();
        for(Coordinate coord:geom.getCoordinates()) {
        	newcoords.add(new CoordinateXYZM(coord.x,coord.y,coord.z*factor,Double.NaN));
        }
        return LiteralUtils.createGeometry(newcoords, geom.getGeometryType(), geom.getSRID());
	}

}
