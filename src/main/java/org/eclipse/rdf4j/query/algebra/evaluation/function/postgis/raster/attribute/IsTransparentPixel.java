package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntIntBooleanFunction;

public class IsTransparentPixel extends RasterAttributeIntIntIntBooleanFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isTransparentPixel.stringValue();
	}


	@Override
	public Boolean attribute(GridCoverage coverage, Integer noband, Integer x, Integer y) {
		int[] valuess=new int[coverage.getSampleDimensions().size()];
		int pixel=coverage.render(null).getTile(x, y).getPixel(x, y, valuess)[noband];
		if((pixel>>24) == 0x00 ) {
		      return true;
		}
		return false;
	}
	
}
