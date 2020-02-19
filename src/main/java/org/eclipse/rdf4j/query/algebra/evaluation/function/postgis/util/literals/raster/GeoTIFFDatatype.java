package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import java.io.IOException;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.geotoolkit.coverage.io.CoverageIO;
import org.geotoolkit.coverage.io.CoverageStoreException;
import org.geotoolkit.image.io.SpatialImageWriteParam;
import org.geotoolkit.image.io.plugin.TiffImageWriter;
import org.opengis.coverage.grid.GridCoverage;

public class GeoTIFFDatatype extends RasterLiteral {

	public static final String URI = POSTGIS.GEOTIFF;
	
	public static final GeoTIFFDatatype INSTANCE=new GeoTIFFDatatype();

	@Override
	public String unparse(GridCoverage geometry) {
			TiffImageWriter writer = new TiffImageWriter(null);
			SpatialImageWriteParam writerParam = writer.getDefaultWriteParam();
			String compression = null;
			/*
			 * if (compression != null) {
			 * writerParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			 * writerParam.setCompressionType(compression); }
			 */
			try {
				writer.write(((GridCoverage2D)geometry).getRenderedImage());
				writer.endWriteSequence();
				return writer.getOutput().toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
	}

	@Override
	public GridCoverage read(String geometryLiteral) {
		GridCoverage2D coverage;
		try {
			coverage = CoverageIO.read(geometryLiteral);
			return coverage;
		} catch (CoverageStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

}
