package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import java.io.IOException;
import java.util.List;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.opengis.util.FactoryException;
import org.wololo.geojson.GeoJSON;
import org.wololo.jts2geojson.GeoJSONWriter;

public class WKBRastDatatype extends RasterLiteral {

	public static final String URI = POSTGIS.WKBRaster;
	
	public static final WKBRastDatatype INSTANCE = new WKBRastDatatype();
	
	@Override
	public GridCoverage read(String geometryLiteral) {
		WKBRasterReader reader2=new WKBRasterReader();
		GridCoverage coverage=reader2.readCoverage(geometryLiteral.getBytes(), authorityFactory);
		return coverage;
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
