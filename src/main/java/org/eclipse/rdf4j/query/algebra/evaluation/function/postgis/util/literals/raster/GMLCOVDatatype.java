package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;


public class GMLCOVDatatype extends RasterLiteral {
	

	public static final String URI=POSTGIS.NAMESPACE+POSTGIS.GMLCOV;
	
	public static final GMLCOVDatatype INSTANCE=new GMLCOVDatatype();
	
	public static final IRI LiteralIRI=SimpleValueFactory.getInstance().createIRI(POSTGIS.NAMESPACE+POSTGIS.GMLCOV);


	@Override
	public GridCoverage read(String geometryLiteral) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String unparse(GridCoverage geom) {
		// TODO Auto-generated method stub
		return null;
	}

}
