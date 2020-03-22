package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.point.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleDoubleFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.util.AffineTransformation;

public class ShearTransformation extends GeometricModifierDoubleDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_shearTransformation.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double xShear, Double yShear) {
        AffineTransformation trans = new AffineTransformation();
        trans.setToShear(xShear, yShear);
        return trans.transform(geom);

	}

}
