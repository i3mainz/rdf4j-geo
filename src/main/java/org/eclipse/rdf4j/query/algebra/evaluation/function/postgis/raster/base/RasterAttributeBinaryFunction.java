package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.query.algebra.evaluation.ValueExprEvaluationException;
import org.eclipse.rdf4j.query.algebra.evaluation.function.Function;
import org.geotoolkit.coverage.grid.GridCoverage2D;

public abstract class RasterAttributeBinaryFunction implements Function {

	@Override
	public Value evaluate(ValueFactory valueFactory, Value... args) throws ValueExprEvaluationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract boolean attribute(GridCoverage2D geom);
}
