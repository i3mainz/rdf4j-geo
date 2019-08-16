package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.constructor;

import java.io.IOException;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterConstructorFunction;
import org.opengis.util.FactoryException;

import com.vividsolutions.jts.io.WKBReader;

public class RastFromHexWKB extends RasterConstructorFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rastFromHexWKB.stringValue();
	}

	@Override
	public GridCoverage construct(String input) {
	            String wkbstring=input;
	    		WKBRasterReader reader=new WKBRasterReader();
	    		GridCoverage coverage;
				try {
					coverage = reader.readCoverage(WKBReader.hexToBytes(wkbstring),null);
					return coverage;
				} catch (IOException | FactoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		return null;
	}

}
