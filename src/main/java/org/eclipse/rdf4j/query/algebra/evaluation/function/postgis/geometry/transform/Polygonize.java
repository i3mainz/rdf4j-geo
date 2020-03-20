package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Geometry;

public class Polygonize extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_polygonize.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
        org.locationtech.jts.operation.polygonize.Polygonizer polygonize=new org.locationtech.jts.operation.polygonize.Polygonizer();
        polygonize.add(geom);
        return polygonize.getGeometry();
	}

}
