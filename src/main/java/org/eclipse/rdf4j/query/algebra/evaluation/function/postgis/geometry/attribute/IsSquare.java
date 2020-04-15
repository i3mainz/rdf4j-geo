package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Geometry;

public class IsSquare extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isSquare.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		if(geom.isRectangle()) {
			Double distance01=geom.getCoordinates()[0].distance(geom.getCoordinates()[1]);
			Double distance12=geom.getCoordinates()[1].distance(geom.getCoordinates()[2]);
			Double distance23=geom.getCoordinates()[2].distance(geom.getCoordinates()[3]);
			Double distance34=geom.getCoordinates()[3].distance(geom.getCoordinates()[0]);
			if(distance01==distance23 && distance12==distance34 && distance01==distance12 && distance23==distance34)
				return true;
		}
		return false;
	}

}
