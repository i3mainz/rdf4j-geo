package org.eclipse.rdf4j.query.algebra.postgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.util.AffineTransformation;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricUnaryFunction;

public class Rotate extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rotate.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
        float rotRadians = arg1.getFloat();
        AffineTransformation trans = new AffineTransformation();
        trans = trans.rotate(rotRadians);
        Geometry transformGeom = trans.transform(geom);

        GeometryWrapper transformGeomWrapper = GeometryWrapperFactory.createGeometry(transformGeom, geometry.getSrsURI(), geometry.getGeometryDatatypeURI());

        return transformGeomWrapper.asNodeValue();
	}
	

}
