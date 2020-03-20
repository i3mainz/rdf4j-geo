package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.shape.random.RandomPointsBuilder;

public class GeneratePoints extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_generatePoints.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer amount) {
		RandomPointsBuilder shapeBuilder = new RandomPointsBuilder(geom.getFactory());
		shapeBuilder.setNumPoints(amount.intValue());
		if(!geom.getGeometryType().equalsIgnoreCase("Polygon")) {
			System.out.println(geom.getGeometryType());
			Geometry convhull=geom.convexHull();
			System.out.println(convhull.getGeometryType());
			if(!convhull.getGeometryType().equalsIgnoreCase("Polygon")) {
				convhull=convhull.convexHull();
			}
			System.out.println(convhull.getGeometryType()+"=====");
			shapeBuilder.setExtent(convhull);
		}else {
			shapeBuilder.setExtent(geom);
		}
		return shapeBuilder.getGeometry();
	}

}
