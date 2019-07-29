package main.java.de.hsmainz.rdf4jpostgis.geometry;

import java.math.BigInteger;

import org.apache.jena.datatypes.DatatypeFormatException;
import org.apache.jena.sparql.expr.ExprEvalException;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.triangulate.DelaunayTriangulationBuilder;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class DelaunayTriangles extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry g1) {
		 try {
	            GeometryWrapper geom = GeometryWrapper.extract(arg0);
	            float tolerance = arg1.getFloat();
	            BigInteger flags = arg2.getInteger();

	            DelaunayTriangulationBuilder builder = new DelaunayTriangulationBuilder();
	            builder.setTolerance(tolerance);
	            Geometry triangles = builder.getTriangles(new GeometryFactory());

	            GeometryWrapper trianglesWrapper = GeometryWrapperFactory.createGeometry(triangles, geom.getSrsURI(), geom.getGeometryDatatypeURI());
	            return trianglesWrapper.asNodeValue();

	        } catch (DatatypeFormatException ex) {
	            throw new ExprEvalException(ex.getMessage(), ex);
	        }
	}

}
