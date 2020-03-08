package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;
import org.locationtech.jts.geom.Geometry;

public class EqualType extends GeometricRelationBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_equalType.stringValue();
	}

	@Override
	protected boolean relation(Geometry g1, Geometry g2) {
		return g1.getGeometryType().equals(g2.getGeometryType());
	}

}
