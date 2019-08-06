package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;

public class GeometryType extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		return geom.getGeometryType();
	}

	@Override
	public String getURI() {
		return POSTGIS.st_geometryType.stringValue();
	}

}
