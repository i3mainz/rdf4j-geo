package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.exporter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterStringExportFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.CovJSONDatatype;

public class AsCoverageJSON extends RasterStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ASCOVERAGEJSON.stringValue();
	}

	@Override
	public String operation(GridCoverage raster) {
		return CovJSONDatatype.INSTANCE.unparse(raster);
	}
}
