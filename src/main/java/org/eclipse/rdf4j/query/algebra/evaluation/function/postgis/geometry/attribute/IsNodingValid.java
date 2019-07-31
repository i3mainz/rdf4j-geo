package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.noding.FastNodingValidator;
import org.locationtech.jts.noding.SegmentStringUtil;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsNodingValid extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		FastNodingValidator nv = new FastNodingValidator(
		        SegmentStringUtil.extractNodedSegmentStrings(geom));
		return nv.isValid();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isNodingValid.stringValue();
	}
	
	

}
