package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntFunction;

public class Band extends RasterAttributeIntIntFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_BAND.stringValue();
	}


	@Override
	public Integer attribute(GridCoverage geom,Integer numband) {
		//return geom.getSampleDimensions().get(numband);
		return 0;
	}

}
