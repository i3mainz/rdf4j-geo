package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricUnaryFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geomgraph.GeometryGraph;

public class DissolveSegments extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_dissolvesegments.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		GeometryFactory fac=new GeometryFactory();
        List<Point> res=new LinkedList<Point>();
        GeometryGraph graph= new GeometryGraph(0,geom);
        //graph.
        /*for(Coordinate coord:geom.getGeome) {
        	res.add(fac.createPoint(coord));
        }*/
        //return fac.createMultiPoint(geom.getCoordinates());
        return null;
	}

}
