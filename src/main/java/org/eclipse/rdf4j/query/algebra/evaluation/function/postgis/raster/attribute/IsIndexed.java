package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBinaryFunction;
import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.image.ImageWorker;

public class IsIndexed extends RasterAttributeBinaryFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_isIndexed.stringValue();
	}

	@Override
	public boolean attribute(GridCoverage2D raster) {
	    ImageWorker worker=new ImageWorker(raster.getRenderedImage());
		return worker.isIndexed();
	}

}
