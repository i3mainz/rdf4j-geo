package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricDoubleModifierIntegerFunction;
import org.locationtech.jts.geom.Geometry;

/**
 * Returns the point within the given geometry nearest to the given length.
 */
public class LengthToPoint extends GeometricDoubleModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_LengthToPoint.stringValue();
	}

	@Override
	protected Geometry relation(Geometry line, Geometry point, Integer value) {
		/*org.locationtech.jump.algorithm.LengthToPoint ltop=new org.locationtech.jump.algorithm.LengthToPoint(line, point.getCoordinates()[0]);
			GeometryWrapper transGeom2;
			try {
				transGeom2 = geom2.transform(geom1.getSrsInfo());
				if(geom1.getXYGeometry().getGeometryType().equalsIgnoreCase("LineString") && 
						transGeom2.getXYGeometry().getGeometryType().equalsIgnoreCase("Point")) {
					LineString line=(LineString) geom1.getXYGeometry();
					Point point=(Point) transGeom2.getXYGeometry();
					//Double minDistance=Double.MAX_VALUE;
					
					return NodeValue.makeDouble(ltop.getLength());
				}
				throw new ExprEvalException("Input geometries were not a point and a linestring");
			} catch (MismatchedDimensionException | TransformException | FactoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ExprEvalException("An exception occurred: "+e.getMessage());
			}*/
		return null;
	}

}
