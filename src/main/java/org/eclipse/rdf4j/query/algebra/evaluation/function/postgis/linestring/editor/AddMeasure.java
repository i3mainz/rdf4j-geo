package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.editor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Geometry;

public class AddMeasure extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_addMeasure.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double value) {
		// TODO Auto-generated method stub
		return null;
	}

}
