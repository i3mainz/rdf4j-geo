package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import gars.LLtoGARS;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;

public class AsGARS extends GeometricStringExportFunction {
	
	@Override
	public String operation(Geometry geom) {
		if(geom.getGeometryType().equals("Point")) {
			return LLtoGARS.getGARS(geom.getCoordinate().getX(), geom.getCoordinate().getY());
		}else {
			return LLtoGARS.getGARS(geom.getCentroid().getCoordinate().getX(), geom.getCentroid().getCoordinate().getY());
		}
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGARS.stringValue();
	}

}
