package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import java.util.Set;
import java.util.HashSet;

public class NumDistinctPoints extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_numDistinctPoints.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
		Set<Coordinate> coordset=new HashSet<Coordinate>();
		for(Coordinate coord:geom.getCoordinates()) {
			coordset.add(coord);
		}
		return coordset.size();
	}
}
