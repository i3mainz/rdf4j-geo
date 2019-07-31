package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.relation;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterVectorRelationFunction;
import org.locationtech.jts.geom.Geometry;

public class Intersection extends RasterVectorRelationFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_rast_Intersection.stringValue();
	}

	@Override
	public Geometry relation(Value v1, Value v2) {
		Boolean type=vectorOrRaster(getLiteral(this, v1));
		Boolean type2=vectorOrRaster(getLiteral(this, v2));
		if(type==null || type2==null) {
			return null;
		}else if(type && type2) {
			//Vector-Vector
		}else if(type && !type2) {
			//Vector-Raster
		}else if(!type && type2) {
			//Raster-Vector
		}else {
			//Raster-Raster
		}
		return null;
	}

}
