package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import java.math.BigInteger;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeBinaryFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeFunction;
import org.geotoolkit.coverage.grid.GridCoverage2D;

public class HasNoBand extends RasterAttributeBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_hasNoBand.stringValue();
	}

	@Override
	public boolean attribute(GridCoverage2D raster) {
		BigInteger noband=v1.getInteger();
		if(noband.intValue()>raster.getRenderedImage().getData().getNumBands()) {
			return false;
		}
		return true;
	}

}
