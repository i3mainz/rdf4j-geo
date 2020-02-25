package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.constructor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricConstructor;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import ch.hsr.geohash.GeoHash;

public class GeomCollFromText extends GeometricConstructor{

	@Override
	public Geometry construct(String input) {
		GeoHash hash=GeoHash.fromGeohashString(input);
		Coordinate coord=new Coordinate(hash.getOriginatingPoint().getLatitude(), hash.getOriginatingPoint().getLongitude());
		List<Coordinate> coords=new LinkedList<Coordinate>();
		coords.add(coord);
		return LiteralUtils.createGeometry(coords, "Point", 4326);	
	}

	@Override
	public String getURI() {
		return POSTGIS.st_geomCollFromText.stringValue();
	}

}
