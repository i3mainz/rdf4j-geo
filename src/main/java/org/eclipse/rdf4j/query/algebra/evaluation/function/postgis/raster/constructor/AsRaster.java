package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.constructor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRasterFunction;
import org.locationtech.jts.geom.Geometry;

public class AsRaster extends GeometricRasterFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_asRaster.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, String pixeltype, Double value, Double nodataval, Boolean touched) {
		
		// TODO Auto-generated method stub
		return null;
	}

}
