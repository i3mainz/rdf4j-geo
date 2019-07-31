package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.coverage.wkb.WKBRasterReader;
import org.geotoolkit.coverage.wkb.WKBRasterWriter;
import org.geotoolkit.gml.xml.v321.GeographicCRSType;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBReader;
import org.locationtech.jts.io.WKBWriter;
import org.opengis.coverage.grid.GridCoverage;
import org.opengis.referencing.crs.CRSAuthorityFactory;
import org.opengis.referencing.crs.GeocentricCRS;
import org.opengis.referencing.crs.GeographicCRS;
import org.opengis.util.FactoryException;

public class HexWKBRastDatatype extends RasterLiteral {

	public static final String URI = POSTGIS.HexWKBRaster;
	
	public static final HexWKBRastDatatype INSTANCE =new HexWKBRastDatatype();
	
	@Override
	public String unparse(GridCoverage geometry) {
            WKBRasterWriter writer=new WKBRasterWriter();
			String rasterWKB;
			try {
				rasterWKB = WKBWriter.toHex(writer.write((GridCoverage2D) geometry)).toString();
				return rasterWKB.toString();
			} catch (IOException | FactoryException e) {
				throw new AssertionError(e.getMessage());
			}
	}

	@Override
	public GridCoverage2D read(String geometryLiteral) {
		WKBRasterReader reader2=new WKBRasterReader();
		BufferedImage img=reader2.read(WKBReader.hexToBytes(geometryLiteral));
		GridCoverage2D coverage=reader2.readCoverage(WKBReader.hexToBytes(geometryLiteral), CRS.forCode("EPSG:4326"));
		return new CoverageWrapper(coverage, URI);
	}
	
    @Override
    public String toString() {
        return "HexWKBRasterDatatype{" + URI + '}';
    }
}