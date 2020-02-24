package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import java.io.IOException;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.geotoolkit.coverage.wkb.WKBRasterReader;
import org.geotoolkit.coverage.wkb.WKBRasterWriter;
import org.opengis.util.FactoryException;

public class WKBRastDatatype extends RasterLiteral {

	public static final String URI = POSTGIS.WKBRaster;
	
	public static final WKBRastDatatype INSTANCE = new WKBRastDatatype();
	
	@Override
	public GridCoverage read(String geometryLiteral) {
		WKBRasterReader reader2=new WKBRasterReader();
		GridCoverage coverage;
		try {
			coverage = reader2.readCoverage(geometryLiteral.getBytes(), null);
			return coverage;
		} catch (IOException | FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
    @Override
    public String toString() {
        return "WKBRasterDatatype{" + URI + '}';
    }

	@Override
	public String unparse(GridCoverage geom) {
        WKBRasterWriter writer=new WKBRasterWriter();
		String rasterWKB;
		try {
			rasterWKB = writer.write(geom).toString();
			return rasterWKB.toString();
		} catch (IOException | FactoryException e) {
			throw new AssertionError(e.getMessage());
		}
	}

}
