package org.eclipse.rdf4j.query.algebra.postgis.geometry.relation;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricDoubleAttributeFunction;
import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricRelationDoubleFunction;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.operation.TransformException;
import org.opengis.util.FactoryException;

public class DistanceSphere extends GeometricRelationDoubleFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected double relation(Geometry geom1, Geometry geom2) {
			Geometry transformed=LiteralUtils.transform(geom2, geom1);
            double distance = geom1. distanceGreatCircle(transformed);
            return distance;
       
	}

}
