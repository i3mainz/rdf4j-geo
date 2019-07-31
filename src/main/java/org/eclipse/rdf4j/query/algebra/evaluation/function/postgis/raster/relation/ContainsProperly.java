package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.relation;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterVectorRelationBinaryFunction;

public class ContainsProperly extends RasterVectorRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_CONTAINSPROPERLY.stringValue();
	}

	@Override
	public Boolean relation(Value v1, Value v2) {
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
