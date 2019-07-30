package main.java.de.hsmainz.rdf4jpostgis.point;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.algorithm.CGAlgorithms;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricRelationBinaryFunction;

public class IsPointInRing extends GeometricRelationBinaryFunction{

	@Override
	public boolean relation(Geometry ringgeom,Geometry pointgeom) {
        CGAlgorithms algos=new CGAlgorithms();
        return algos.isPointInRing(pointgeom.getCoordinate(), ringgeom.getCoordinates());
	}

	@Override
	public String getURI() {
		return POSTGIS.st_isPointInRing.stringValue();
	}

}
