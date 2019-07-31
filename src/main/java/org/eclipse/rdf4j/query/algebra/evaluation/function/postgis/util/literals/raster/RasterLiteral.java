package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.LiteralType;
import org.opengis.coverage.grid.GridCoverage;

public abstract class RasterLiteral implements LiteralType {

	public abstract String unparse(GridCoverage geom);
	
	public abstract GridCoverage read(String literalValue);
	
}
