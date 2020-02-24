package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBooleanIntFunction;

public class BandIsNoData extends RasterAttributeBooleanIntFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return POSTGIS.ST_BANDISNODATA.stringValue();
	}

	@Override
	public Boolean attribute(GridCoverage coverage, Integer bandno) {
		if(coverage.getSampleDimensions().get(bandno).getSampleRange().get().isEmpty()) {
			return true;
		}
		return false;
		//if(coverage.getSampleDimensions().get(bandno).getSampleRange().get().)
	}

}
