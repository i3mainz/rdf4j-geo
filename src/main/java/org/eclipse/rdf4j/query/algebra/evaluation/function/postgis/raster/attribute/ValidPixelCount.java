package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import java.awt.image.RenderedImage;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntFunction;

public class ValidPixelCount extends RasterAttributeIntIntFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_validpixelcount.stringValue();
	}

	@Override
	public Integer attribute(GridCoverage raster,Integer bandnum) {
		RenderedImage rendered = raster.render(null);
		Integer result=0;
        for(int i=0;i<rendered.getSampleModel().getWidth();i++) {
        	for(int j=0;j<rendered.getSampleModel().getHeight();j++) {       			
        		Number sample=rendered.getData().getSample(i, j, bandnum);
        		if(!raster.getSampleDimensions().get(bandnum).getNoDataValues().contains(sample)) {
        			result++;
        		}
        	}
        }
        return result;
	}

}
