package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntFunction;

public class BandNoDataValue extends RasterAttributeIntIntFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_BANDNODATAVALUE.stringValue();
	}

	@Override
	public Integer attribute(GridCoverage coverage,Integer bandno) {
		return coverage.getSampleDimensions().get(bandno).getNoDataValues().iterator().next().intValue();
	}

}
