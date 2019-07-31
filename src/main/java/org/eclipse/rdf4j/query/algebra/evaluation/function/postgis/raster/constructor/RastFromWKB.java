package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.constructor;

import java.io.IOException;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterConstructorFunction;
import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.coverage.wkb.WKBRasterReader;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.util.FactoryException;

public class RastFromWKB extends RasterConstructorFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rastFromWKB.stringValue();
	}

	@Override
	public GridCoverage2D construct(String input) {
            String wkbstring=input;
    		WKBRasterReader reader=new WKBRasterReader();
    		GridCoverage2D coverage;
			try {
				coverage = reader.readCoverage(wkbstring.getBytes(),null);
	    		return coverage;
			} catch (IOException | FactoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}

}
