package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeDoubleIntFunction;

public class BandMax extends RasterAttributeDoubleIntFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return POSTGIS.ST_BANDMAX.stringValue();
	}

	@Override
	public Double attribute(GridCoverage coverage, Integer bandno) {
		return coverage.getSampleDimensions().get(bandno).getSampleRange().get().getMaxDouble();
	}

}
