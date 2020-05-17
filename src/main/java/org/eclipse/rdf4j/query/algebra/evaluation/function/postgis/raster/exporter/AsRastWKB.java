package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.exporter;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterStringExportFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.WKBRastDatatype;

public class AsBinary extends RasterStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_asRasterWKB.stringValue();
	}

	@Override
	public String operation(GridCoverage raster) {
		return WKBRastDatatype.INSTANCE.unparse(raster);
	}

}