package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterModifierFunction;

public class ScaleX extends RasterModifierFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_scaleX.stringValue();
	}

}
