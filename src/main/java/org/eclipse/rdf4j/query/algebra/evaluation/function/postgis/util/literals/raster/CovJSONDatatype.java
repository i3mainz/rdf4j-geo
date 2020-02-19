package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.geotoolkit.coverage.grid.GridCoverage2D;
import org.locationtech.jts.geom.Geometry;
import org.opengis.coverage.grid.GridCoverage;

import io.github.galbiston.geosparql_jena.implementation.CoverageWrapper;
import uk.ac.rdg.resc.edal.covjson.CoverageJsonConverterImpl;
import uk.ac.rdg.resc.edal.covjson.CoverageJsonWriter;
import uk.ac.rdg.resc.edal.covjson.StreamingEncoder;
import uk.ac.rdg.resc.edal.covjson.writers.Coverage;
import uk.ac.rdg.resc.edal.feature.Feature;

public class CovJSONDatatype extends RasterLiteral{

	public static final String URI = POSTGIS.CoverageJSON;
	
	public static final CovJSONDatatype INSTANCE=new CovJSONDatatype();

	@Override
	public GridCoverage read(String geometryLiteral) {
		CoverageJsonConverterImpl covjsonconverter=new CoverageJsonConverterImpl();
		Feature feat;
		Coverage coverage;
		covjsonconverter.convertFeatureToJson(os, feat);
	}
	
	@Override
	public String unparse(GridCoverage value) {
		CoverageJsonWriter writer=new CoverageJsonWriter(new StreamingEncoder());
		// TODO Auto-generated method stub
		return super.unparse(value);
	}

}
