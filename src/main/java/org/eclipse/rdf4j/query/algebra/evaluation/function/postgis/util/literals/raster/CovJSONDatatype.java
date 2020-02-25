package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.parsers.CoverageJSONReader;

public class CovJSONDatatype extends RasterLiteral{

	public static final String URI = POSTGIS.CoverageJSON;
	
	public static final CovJSONDatatype INSTANCE=new CovJSONDatatype();

	@Override
	public GridCoverage read(String geometryLiteral) {
		return CoverageJSONReader.covJSONStringToCoverage(geometryLiteral);
		
	}
	
	@Override
	public String unparse(GridCoverage geom) {
		/*
		CoverageJsonConverterImpl covjsonconverter=new CoverageJsonConverterImpl();
		covjsonconverter.con
		covjsonconverter.convertFeatureToJson(os, feat);
		CoverageJsonWriter writer=new CoverageJsonWriter(new StreamingEncoder());
		// TODO Auto-generated method stub
		return super.unparse(value);
		*/
		return null;
	}

}
