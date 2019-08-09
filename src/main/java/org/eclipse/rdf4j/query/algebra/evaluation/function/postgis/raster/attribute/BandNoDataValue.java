package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterStringExportFunction;

public class BandNoDataValue extends RasterStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_BANDNODATAVALUE.stringValue();
	}

	@Override
	public String operation(GridCoverage raster) {
		// TODO Auto-generated method stub
		return null;
	}

}
