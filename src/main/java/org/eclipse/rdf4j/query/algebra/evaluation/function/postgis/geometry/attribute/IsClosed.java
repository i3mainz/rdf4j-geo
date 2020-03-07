package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.MultiPoint;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;

/**
 * Returns true if the given geometry is closed, false otherwise.
 */
public class IsClosed extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		if(geom instanceof Point)
        	return false;
        if(geom instanceof MultiPoint) {
        	GeometryFactory fac=new GeometryFactory();
        	LineString line=fac.createLineString(((MultiPoint)geom).getCoordinates());
        	return line.isClosed();        	
        }
        if (geom instanceof LineString) {
            boolean isClosed = ((LineString) geom).isClosed();
            return isClosed;
        }
        if (geom instanceof Polygon) {
            return true;
        }

        return false;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isClosed.stringValue();
	}

}
