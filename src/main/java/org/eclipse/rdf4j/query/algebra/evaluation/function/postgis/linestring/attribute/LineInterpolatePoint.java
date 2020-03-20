package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.linearref.LengthLocationMap;
import org.locationtech.jts.linearref.LinearLocation;


public class LineInterpolatePoint extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_lineInterpolatePoint.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double a_fraction) {
		GeometryFactory fac=new GeometryFactory();
		Double length=geom.getLength();
		Double fractionlength=a_fraction*length;
	    LengthLocationMap locmap=new LengthLocationMap(geom);
	    LinearLocation linloc=locmap.getLocation(fractionlength);
	    Coordinate coord=linloc.getCoordinate(geom);
		return fac.createPoint(coord);
	}

}
