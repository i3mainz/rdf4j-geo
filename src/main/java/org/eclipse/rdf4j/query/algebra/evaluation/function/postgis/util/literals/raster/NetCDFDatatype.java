package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.storage.StorageConnector;
import org.apache.sis.storage.netcdf.NetcdfStore;
import org.apache.sis.storage.netcdf.NetcdfStoreProvider;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;

public class NetCDFDatatype extends RasterLiteral {

	public static final String URI=POSTGIS.NETCDF;
	
	public static final GMLCOVDatatype INSTANCE=new GMLCOVDatatype();

	@Override
	public GridCoverage read(String literalValue) {
		//StorageConnector connect=new StorageConnector(connect);
		//NetcdfStore netcdf=new NetcdfStoreProvider().open(connector);
		//netcdf.
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unparse(GridCoverage geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
