package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.triangulate.DelaunayTriangulationBuilder;

public class DelaunayTriangles extends GeometricModifierDoubleFunction {
	
	@Override
	public String getURI() {
		return POSTGIS.ST_DELAUNAYTRIANGLES.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double tolerance) {
	    DelaunayTriangulationBuilder builder = new DelaunayTriangulationBuilder();
	    builder.setTolerance(tolerance);
	    Geometry triangles = builder.getTriangles(new GeometryFactory());
	    return triangles;
	}

}
