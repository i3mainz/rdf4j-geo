package main.java.de.hsmainz.rdf4jpostgis.point;

import org.locationtech.jts.algorithm.CGAlgorithms;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationBinaryFunction;

public class IsPointOnLine extends GeometricRelationBinaryFunction{

	@Override
	protected boolean relation(Geometry linegeom, Geometry pointgeom) {
		CGAlgorithms algos=new CGAlgorithms();
        return algos.isOnLine(pointgeom.getCoordinate(), linegeom.getCoordinates());
	}
	
}
