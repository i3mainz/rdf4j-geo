package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.locationtech.jts.geom.Geometry;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class Translate extends GeometricUnaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_translate.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		/*double deltaX = arg1.getDouble();
        double deltaY = arg2.getDouble();

        //Translate and scale
        AffineTransformation transform = new AffineTransformation();
        transform.translate(deltaX, deltaY);

        Geometry transGeom = transform.transform(geom);
        GeometryWrapper transWrapper = GeometryWrapperFactory.createGeometry(transGeom, geometry.getSrsURI(), geometry.getGeometryDatatypeURI());
        return transWrapper.asNodeValue();*/
		return null;
	}

}
