package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.constructor;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.base.RasterGeometryConversionFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterVectorRelationFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.util.PolygonExtracter;

public class AsGeometry extends RasterGeometryConversionFunction {


	
	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Geometry construct(GridCoverage input) {
		//PolygonExtracter extractor = new PolygonExtracter(null);
		// TODO Auto-generated method stub
		return null;
	}

}
