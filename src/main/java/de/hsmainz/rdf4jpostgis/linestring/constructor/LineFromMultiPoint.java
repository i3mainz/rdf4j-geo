package main.java.de.hsmainz.rdf4jpostgis.linestring.constructor;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPoint;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricConstructor;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierFunction;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

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
		// TODO Auto-generated method stub
		return null;
	}

}
