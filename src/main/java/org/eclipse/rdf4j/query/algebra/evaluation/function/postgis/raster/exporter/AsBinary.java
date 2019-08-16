package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.exporter;

import java.io.IOException;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterStringExportFunction;
import org.opengis.util.FactoryException;

public class AsBinary extends RasterStringExportFunction {

	@Override
	public String getURI() {
		return null;
	}

	@Override
	public String operation(GridCoverage raster) {
		WKBRasterWriter writer=new WKBRasterWriter();
		String rasterWKB;
		try {
			rasterWKB = writer.write(raster).toString();
			return rasterWKB.toString();
		} catch (IOException | FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
