package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBooleanIntFunction;

public class HasNoBand extends RasterAttributeBooleanIntFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_hasNoBand.stringValue();
	}

	@Override
	public Boolean attribute(GridCoverage raster, Integer noband) {
		if(noband>raster.getSampleDimensions().size()) {
			return false;
		}
		return true;
	}

}
