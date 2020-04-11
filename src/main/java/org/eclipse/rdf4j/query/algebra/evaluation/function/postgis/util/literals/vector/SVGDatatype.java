package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.GMLCOVDatatype;
import org.locationtech.jts.geom.Geometry;

public class SVGDatatype extends VectorLiteral {

	public static final String URI=POSTGIS.NAMESPACE+POSTGIS.SVG;
	
	public static final SVGDatatype INSTANCE=new SVGDatatype();
	
    public static final IRI LiteralIRI=SimpleValueFactory.getInstance().createIRI(POSTGIS.NAMESPACE+POSTGIS.SVG);
	
	@Override
	public String unparse(Geometry geom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Geometry read(String literalValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
