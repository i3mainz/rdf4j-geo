package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import java.math.BigInteger;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class IsLocationOnEdge extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isLocationOnEdge.stringValue();
	}

	@Override
	public double attribute(Geometry geom, Integer ringN) {
		if (geom instanceof Polygon) {
        	LineString result=((Polygon) geom).getInteriorRingN(ringN.intValue());
        	GeometryWrapper lineStringWrapper = GeometryWrapperFactory.createGeometry(result, geometry.getSrsURI(), WKTDatatype.URI);
        	return lineStringWrapper.asNodeValue();
        }
	}

}
