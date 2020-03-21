package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.triangulate.VoronoiDiagramBuilder;

public class VoronoiPolygons extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_voronoiPolygons.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double tolerance) {
		VoronoiDiagramBuilder builder=new VoronoiDiagramBuilder();
		builder.setTolerance(tolerance);
		builder.setSites(geom);
		Geometry test = builder.getDiagram(new GeometryFactory());
	    return test;
	}

}
