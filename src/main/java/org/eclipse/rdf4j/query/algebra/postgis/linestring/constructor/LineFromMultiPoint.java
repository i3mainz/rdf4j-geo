package org.eclipse.rdf4j.query.algebra.postgis.linestring.constructor;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPoint;

import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricConstructor;
import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricModifierFunction;
import org.eclipse.rdf4j.query.algebra.postgis.geometry.base.GeometricUnaryFunction;

public class LineFromMultiPoint extends GeometricUnaryFunction {


	@Override
	protected Geometry operation(Geometry geom) {
		if(geom.getGeometryType()=="MultiPoint"){
			MultiPoint mp=(MultiPoint) geom;
			GeometryFactory fac=new GeometryFactory();
			return LiteralUtils.createGeometry(geom.getCoordinates(), "LINESTRING", geom.getSRID());
		}	
		return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.st_lineFromMultiPoint.stringValue();
	}

}
