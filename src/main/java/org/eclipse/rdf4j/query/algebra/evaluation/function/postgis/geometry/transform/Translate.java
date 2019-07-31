package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.util.AffineTransformation;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Translate extends GeometricUnaryFunction{

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {
		double deltaX = arg1.getDouble();
        double deltaY = arg2.getDouble();

        //Translate and scale
        AffineTransformation transform = new AffineTransformation();
        transform.translate(deltaX, deltaY);

        Geometry transGeom = transform.transform(geom);
        GeometryWrapper transWrapper = GeometryWrapperFactory.createGeometry(transGeom, geometry.getSrsURI(), geometry.getGeometryDatatypeURI());
        return transWrapper.asNodeValue();
	}

}
