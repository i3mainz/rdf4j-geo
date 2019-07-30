package org.eclipse.rdf4j.query.algebra.postgis.linestring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiLineString;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricUnaryFunction;

public class LineMerge extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_lineMerge.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
         if (geom instanceof MultiLineString) {
         	List<Coordinate> resultcoords=new LinkedList<Coordinate>();
         	for(int i=0;i<((MultiLineString) geom).getLength();i++) {
         		resultcoords.addAll(Arrays.asList(((MultiLineString) geom).getGeometryN(i).getCoordinates()));
         	}
         	GeometryFactory fac=new GeometryFactory();
         	return LiteralUtils.createGeometry(resultcoords.toArray(new Coordinate[0]), "LINESTRING",geom.getSRID());
         }
         return null;
	}

}
