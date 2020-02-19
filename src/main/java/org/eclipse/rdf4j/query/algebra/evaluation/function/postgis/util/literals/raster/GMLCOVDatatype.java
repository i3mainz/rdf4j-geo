package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.opengis.coverage.grid.GridCoverage;


public class GMLCOVDatatype extends RasterLiteral {
	

	public static final String URI=POSTGIS.GMLCOV;
	
	public static final GMLCOVDatatype INSTANCE=new GMLCOVDatatype();

	@Override
	public GridCoverage read(String geometryLiteral) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unparse(GridCoverage geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
