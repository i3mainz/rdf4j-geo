package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.constructor;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;

public class MakeEmptyRaster extends RasterAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_makeEmptyRaster.stringValue();
	}

	@Override
	public Double attribute(GridCoverage geom) {
		// TODO Auto-generated method stub
		return 0.;
	}

}
