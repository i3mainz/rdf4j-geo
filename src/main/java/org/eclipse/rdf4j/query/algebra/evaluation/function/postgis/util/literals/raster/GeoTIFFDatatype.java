package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import java.io.IOException;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.storage.geotiff.GeoTiffStore;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;


public class GeoTIFFDatatype extends RasterLiteral {

	public static final String URI = POSTGIS.GEOTIFF;
	
	public static final GeoTIFFDatatype INSTANCE=new GeoTIFFDatatype();
	
	public static final IRI LiteralIRI=SimpleValueFactory.getInstance().createIRI(POSTGIS.NAMESPACE+"geoTIFFLiteral");


	@Override
	public GridCoverage read(String geometryLiteral) {
		GridCoverage coverage;
		/*GeoTiffStore store=new GeoTiffStore(provider, connector)
		//try {
			coverage = CoverageIO.read(geometryLiteral);
			return coverage;
		} catch (CoverageStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}*/
		return null;

	}

	@Override
	public String unparse(GridCoverage geom) {
		/*TiffImageWriter writer = new TiffImageWriter(null);
		SpatialImageWriteParam writerParam = writer.getDefaultWriteParam();
		String compression = null;
		/*
		 * if (compression != null) {
		 * writerParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		 * writerParam.setCompressionType(compression); }
		 
		try {
			writer.write(((GridCoverage)geometry).getRenderedImage());
			writer.endWriteSequence();
			return writer.getOutput().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}*/
		return null;
	}

}
