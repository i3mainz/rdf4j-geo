package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.editor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;

public class AddBand extends RasterModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_ADDBAND.stringValue();
	}

}
