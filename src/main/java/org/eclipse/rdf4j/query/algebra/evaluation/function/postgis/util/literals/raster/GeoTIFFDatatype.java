package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import java.io.IOException;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;


public class GeoTIFFDatatype extends RasterLiteral {

	public static final String URI = POSTGIS.GEOTIFF;
	
	public static final GeoTIFFDatatype INSTANCE=new GeoTIFFDatatype();

	@Override
	public GridCoverage read(String geometryLiteral) {
		GridCoverage coverage;
		try {
			coverage = CoverageIO.read(geometryLiteral);
			return coverage;
		} catch (CoverageStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	@Override
	public String unparse(GridCoverage geom) {
		TiffImageWriter writer = new TiffImageWriter(null);
		SpatialImageWriteParam writerParam = writer.getDefaultWriteParam();
		String compression = null;
		/*
		 * if (compression != null) {
		 * writerParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		 * writerParam.setCompressionType(compression); }
		 */
		try {
			writer.write(((GridCoverage)geometry).getRenderedImage());
			writer.endWriteSequence();
			return writer.getOutput().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
