package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.exporter;

import java.io.IOException;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterStringExportFunction;
import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.coverage.wkb.WKBRasterWriter;
import org.locationtech.jts.io.WKBWriter;
import org.opengis.util.FactoryException;

public class AsHexWKB extends RasterStringExportFunction {

	@Override
	public String getURI() {
		return null;
	}

	@Override
	public String operation(GridCoverage2D raster) {	
		WKBRasterWriter writer=new WKBRasterWriter();
		String rasterWKB;
		try {
			rasterWKB = WKBWriter.toHex(writer.write(raster)).toString();
			return rasterWKB.toString();
		} catch (IOException | FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	

}
