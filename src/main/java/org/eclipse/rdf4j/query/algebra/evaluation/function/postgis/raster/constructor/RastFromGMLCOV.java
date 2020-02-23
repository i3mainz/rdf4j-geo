package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.constructor;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterConstructorFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.GMLCOVDatatype;

public class RastFromGMLCOV extends RasterConstructorFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rastFromGMLCOV.stringValue();
	}

	@Override
	public GridCoverage construct(String input) {
		return GMLCOVDatatype.INSTANCE.read(input);
	}

}
