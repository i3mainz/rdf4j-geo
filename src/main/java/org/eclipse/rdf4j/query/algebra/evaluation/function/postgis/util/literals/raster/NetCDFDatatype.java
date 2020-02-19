package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.opengis.coverage.grid.GridCoverage;

public class NetCDFDatatype extends RasterLiteral {

	public static final String URI=POSTGIS.NETCDF;
	
	public static final GMLCOVDatatype INSTANCE=new GMLCOVDatatype();
	
	@Override
	public String unparse(GridCoverage geom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GridCoverage read(String literalValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
