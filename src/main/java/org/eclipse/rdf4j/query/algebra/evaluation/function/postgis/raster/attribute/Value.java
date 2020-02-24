package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.attribute;

import org.apache.sis.coverage.grid.GridCoverage;
import org.apache.sis.geometry.DirectPosition2D;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterAttributeIntIntIntStringFunction;

public class Value extends RasterAttributeIntIntIntStringFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_value.stringValue();
	}
	
	@Override
	public Double attribute(GridCoverage coverage,Integer noband,Integer x,Integer y,Boolean excludenodata) {
		DirectPosition2D directpos=new DirectPosition2D(x, y);
		double[] values=new double[coverage.getSampleDimensions().size()];
		coverage.evaluate(directpos, values);
		return values[noband];
	}

}
