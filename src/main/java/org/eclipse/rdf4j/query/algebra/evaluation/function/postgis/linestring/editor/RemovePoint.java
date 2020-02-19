package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.editor;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;

public class RemovePoint extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_removePoint.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Integer zerobasedposition) {
		Coordinate[] coords=geom1.getCoordinates();
		if(zerobasedposition>=coords.length || zerobasedposition<0) {
			return null;
		}
		return LiteralUtils.createGeometry(ArrayUtils.remove(coords, zerobasedposition), geom1.getGeometryType(), geom1.getSRID());
	}

}
