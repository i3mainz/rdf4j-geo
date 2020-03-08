package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationStringFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.relate.RelateOp;

public class IntersectionMatrix extends GeometricRelationStringFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_intersectionMatrix.stringValue();
	}

	
	IntersectionMatrix matrix=new IntersectionMatrix();
	@Override
	protected String relation(Geometry geom, Geometry geom2) {
		RelateOp relop=new RelateOp(geom, geom2);
        org.locationtech.jts.geom.IntersectionMatrix matrix=relop.getIntersectionMatrix();
        return matrix.toString();
	}


}
