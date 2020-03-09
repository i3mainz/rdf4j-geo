package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.attribute;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleDoubleFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class LocateBetweenMeasures extends GeometricModifierDoubleDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_locateBetween.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double minmvalue,Double maxmvalue) {
		GeometryFactory fac=new GeometryFactory();
		List<Coordinate> resultpoint=new LinkedList<Coordinate>();
		for(Coordinate coord:geom.getCoordinates()) {
			if(coord.getM()>=minmvalue && coord.getM()<=maxmvalue) {
				resultpoint.add(coord);
			}
		}
		if(resultpoint.size()==1) {
			return fac.createPoint(resultpoint.get(0));
		}else {
			return fac.createMultiPoint(resultpoint.toArray(new Coordinate[0]));			
		}
	}

}
