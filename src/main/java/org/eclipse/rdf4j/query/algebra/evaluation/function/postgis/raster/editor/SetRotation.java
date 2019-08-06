package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.editor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;
import org.opengis.coverage.grid.GridCoverage;

public class SetRotation extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setRotation.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage coverage) {
		// TODO Auto-generated method stub
		return null;
	}

}
