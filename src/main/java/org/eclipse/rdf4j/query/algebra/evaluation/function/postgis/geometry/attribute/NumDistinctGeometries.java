package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricIntegerAttributeFunction;
import org.locationtech.jts.geom.Geometry;

/**
 * Returns the number of distinct geometries included in this geometry.
 */
public class NumDistinctGeometries extends GeometricIntegerAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_numDistinctGeometries.stringValue();
	}

	@Override
	public int attribute(Geometry geom) {
		Set<Geometry> coordset=new HashSet<Geometry>();
		for(int i=0;i<geom.getNumGeometries();i++) {
			coordset.add(geom.getGeometryN(i));
		}
		return coordset.size();
	}
}
