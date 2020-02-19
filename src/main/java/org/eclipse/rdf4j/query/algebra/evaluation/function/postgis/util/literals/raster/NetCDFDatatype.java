package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;

public class NetCDFDatatype extends RasterLiteral {

	public static final String URI=POSTGIS.NETCDF;
	
	public static final GMLCOVDatatype INSTANCE=new GMLCOVDatatype();

	@Override
	public GridCoverage read(String literalValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unparse(GridCoverage geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
