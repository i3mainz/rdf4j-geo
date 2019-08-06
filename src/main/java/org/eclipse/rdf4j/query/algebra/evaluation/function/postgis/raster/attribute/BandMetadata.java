package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterStringExportFunction;
import org.geotoolkit.coverage.grid.GridCoverage2D;

public class BandMetadata extends RasterStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_BANDMETADATA.stringValue();
	}

	@Override
	public String operation(GridCoverage2D raster) {
		// TODO Auto-generated method stub
		return null;
	}

}
