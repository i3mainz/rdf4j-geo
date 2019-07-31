package org.eclipse.rdf4j.query.algebra.postgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricDoubleAttributeFunction;

public class Perimeter3D extends GeometricDoubleAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_perimeter3D.stringValue();
	}

	@Override
	public double attribute(Geometry geom) {
		double sum = 0;
        for (int i = 0; i < geom.getNumGeometries(); i++) {
            Geometry subGeom = geom.getGeometryN(i);
            if (subGeom instanceof Polygon) {
                sum += LineLength3D.length3D(((Polygon) subGeom).getExteriorRing());
            } 
        }
        return sum;
	}

}