package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import java.io.IOException;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.coverage.wkb.WKBRasterReader;
import org.geotoolkit.coverage.wkb.WKBRasterWriter;
import org.opengis.coverage.grid.GridCoverage;
import org.opengis.util.FactoryException;
import org.wololo.geojson.GeoJSON;
import org.wololo.jts2geojson.GeoJSONWriter;

public class WKBRastDatatype extends RasterLiteral {

	public static final String URI = POSTGIS.WKBRaster;
	
	public static final WKBRastDatatype INSTANCE = new WKBRastDatatype();
	
	@Override
	public String unparse(GridCoverage geometry) {
            WKBRasterWriter writer=new WKBRasterWriter();
			String rasterWKB;
			try {
				rasterWKB = writer.write((GridCoverage2D) geometry).toString();
				return rasterWKB.toString();
			} catch (IOException | FactoryException e) {
				throw new AssertionError(e.getMessage());
			}
	}

	@Override
	public GridCoverage read(String geometryLiteral) {
		WKBRasterReader reader2=new WKBRasterReader();
		GridCoverage2D coverage=reader2.readCoverage(geometryLiteral.getBytes(), authorityFactory);
		return coverage;
	}
	
    @Override
    public String toString() {
        return "WKBRasterDatatype{" + URI + '}';
    }

}
