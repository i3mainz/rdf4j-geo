package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.exporter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterStringExportFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.GeoTIFFDatatype;

public class AsGeoTIFF extends RasterStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGEOTIFF.stringValue();
	}

	@Override
	public String operation(GridCoverage raster) {
		return GeoTIFFDatatype.INSTANCE.unparse(raster);
	}
}
