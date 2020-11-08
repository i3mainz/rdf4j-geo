package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntFunction;

public class MinTileX extends RasterAttributeIntFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_minTileX.stringValue();
	}

	@Override
	public Integer attribute(GridCoverage raster) {
		return raster.render(raster.getGridGeometry().getExtent()).getMinTileX();
	}

}
