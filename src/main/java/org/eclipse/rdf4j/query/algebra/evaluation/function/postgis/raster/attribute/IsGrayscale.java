package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBinaryFunction;

public class IsGrayscale extends RasterAttributeBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_isGrayscale.stringValue();
	}

	@Override
	public boolean attribute(GridCoverage raster) {	
		RenderedImage image=raster.render(null);
		image.getData().getDataBuffer().getDataType();
		// Test the type
	    if ( image.getData().getDataBuffer().getDataType() == BufferedImage.TYPE_BYTE_GRAY ) return true ;
	    if ( image.getData().getDataBuffer().getDataType() == BufferedImage.TYPE_USHORT_GRAY ) return true ;
	    // Test the number of channels / bands
	    if ( image.getData().getNumBands() == 1 ) return true ; // Single channel => gray scale
	    return false;
	}

}
