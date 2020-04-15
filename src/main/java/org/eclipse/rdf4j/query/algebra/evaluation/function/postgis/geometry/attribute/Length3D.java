package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.attribute.LineLength3D;

public class Length3D extends GeometricDoubleAttributeFunction {

	@Override
	public double attribute(Geometry geom) {
       return LineLength3D.length3D(geom);
	}

	@Override
	public String getURI() {
		return POSTGIS.st_Length3D.stringValue();
	}
}
