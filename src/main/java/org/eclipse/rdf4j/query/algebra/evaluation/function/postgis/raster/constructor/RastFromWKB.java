package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.constructor;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterConstructorFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.WKBRastDatatype;

public class RastFromWKB extends RasterConstructorFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rastFromWKB.stringValue();
	}

	@Override
	public GridCoverage construct(String input) {
		return WKBRastDatatype.INSTANCE.read(input);
	}

}
