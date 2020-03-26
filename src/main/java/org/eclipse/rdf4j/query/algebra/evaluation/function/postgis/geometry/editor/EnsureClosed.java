package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.editor;

import java.util.Arrays;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

public class EnsureClosed extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_ensureClosed.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double value) {		
		Coordinate[] array=geom.getCoordinates();
		if(!array[0].equals(array[array.length-1])) {
			List<Coordinate> coords=Arrays.asList(array);
			coords.add(array[0]);
			geom=LiteralUtils.createGeometry(coords.toArray(new Coordinate[0]), geom.getGeometryType(), geom.getSRID());
		}
		return geom;
	}
}
