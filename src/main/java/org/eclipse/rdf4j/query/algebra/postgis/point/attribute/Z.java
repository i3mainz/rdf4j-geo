package main.java.de.hsmainz.rdf4jpostgis.point.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricDoubleAttributeFunction;

public class Z extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
		if(geom.getGeometryType().equalsIgnoreCase("Point")) {
			return geom.getCoordinate().z;
		}
		return geom.getCentroid().getZ();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_z.stringValue();
	}

}
