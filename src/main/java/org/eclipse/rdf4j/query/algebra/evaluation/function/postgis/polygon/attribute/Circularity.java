package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleAttributeFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

public class Circularity extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_circularity.stringValue();
	}



	@Override
	public double attribute(Geometry geom) {
        if (geom instanceof Polygon) {
        	double areasum=0.,perimetersum=0.;
        	for(int i=0;i<geom.getNumGeometries();i++) {
        		areasum+=geom.getArea();
        		perimetersum+=geom.getLength();
        	}
        	return (4*Math.PI*areasum)/(perimetersum*perimetersum);
        }
        return 0.;
	}
}
