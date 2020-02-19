package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry;


import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;

public class DelaunayTriangles extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_DELAUNAYTRIANGLES.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		 //try {
	           /* float tolerance = arg1.getFloat();
	            BigInteger flags = arg2.getInteger();

	            DelaunayTriangulationBuilder builder = new DelaunayTriangulationBuilder();
	            builder.setTolerance(tolerance);
	            Geometry triangles = builder.getTriangles(new GeometryFactory());

	            GeometryWrapper trianglesWrapper = GeometryWrapperFactory.createGeometry(triangles, geom.getSrsURI(), geom.getGeometryDatatypeURI());
	            return trianglesWrapper.asNodeValue();

	        } catch (DatatypeFormatException ex) {
	            throw new ExprEvalException(ex.getMessage(), ex);
	        }*/
			 return null;
	}

}
