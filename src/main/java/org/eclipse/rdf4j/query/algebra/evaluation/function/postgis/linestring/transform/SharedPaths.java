package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.transform;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationModifierFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.locationtech.jts.geom.Geometry;


public class SharedPaths extends GeometricRelationModifierFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_sharedPaths.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
        List<Geometry> intersections=new LinkedList<>();
        Geometry transformed=LiteralUtils.transform(geom2, geom1);
		if((geom1.getGeometryType().equals("MultiLineString") || geom1.getGeometryType().equals("LineString"))
				&& (transformed.getGeometryType().equals("MultiLineString") || transformed.getGeometryType().equals("LineString"))) {
			for(int i=0;i<geom1.getNumGeometries();i++) {
				for(int j=0;j<transformed.getNumGeometries();j++) {
					if(geom1.intersects(transformed.getGeometryN(j))){
						intersections.add(geom1.getGeometryN(i).intersection(transformed.getGeometryN(j)));
					}
				}
			}
			return LiteralUtils.createGeometryCollection(intersections, "GEOMETRYCOLLECTION", geom1.getSRID());
		}
		return null;
	}

}
