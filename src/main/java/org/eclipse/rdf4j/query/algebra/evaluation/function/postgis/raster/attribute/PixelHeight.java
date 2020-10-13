package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntIntBooleanFunction;

public class PixelHeight extends RasterAttributeIntIntIntIntFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_pixelHeight.stringValue();
	}


	@Override
	public Boolean attribute(GridCoverage coverage, Integer noband, Integer x, Integer y) {
		int[] valuess=new int[coverage.getSampleDimensions().size()];
		return coverage.render(null).getTile(x, y).getHeight();
	}

}
