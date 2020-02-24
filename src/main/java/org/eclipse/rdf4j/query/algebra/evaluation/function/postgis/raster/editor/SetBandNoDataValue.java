package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.editor;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierIntIntFunction;

public class SetBandNoDataValue extends RasterModifierIntIntFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setBandNoDataValue.stringValue();
	}

	@Override
	public GridCoverage modify(GridCoverage coverage, Integer bandno, Integer nodatavalue) {
		// TODO Auto-generated method stub
		return null;
	}

}
