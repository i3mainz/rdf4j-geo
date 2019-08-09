package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.raster.relation;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralRegistry;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.LiteralUtils;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.RasterVectorRelationBinaryFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.raster.RasterLiteral;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.VectorLiteral;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;

public class ContainsProperly extends RasterVectorRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.ST_CONTAINSPROPERLY.stringValue();
	}

	@Override
	public Boolean relation(Value v1, Value v2) {
		Literal lit1=getLiteral(this, v1);
		Literal lit2=getLiteral(this, v2);
		Boolean type=vectorOrRaster(getLiteral(this, v1));
		Boolean type2=vectorOrRaster(getLiteral(this, v2));
		if(type==null || type2==null) {
			return null;
		}else if(type && type2) {
			VectorLiteral vec1=(VectorLiteral) LiteralRegistry.getLiteral(lit1.getDatatype().toString());
			VectorLiteral vec2=(VectorLiteral) LiteralRegistry.getLiteral(lit2.getDatatype().toString());
			return containsProperly(vec1.read(v1.stringValue()),vec2.read(v2.stringValue()));
		}else if(type && !type2) {
			VectorLiteral vec1=(VectorLiteral) LiteralRegistry.getLiteral(lit1.getDatatype().toString());
			RasterLiteral vec2=(RasterLiteral) LiteralRegistry.getLiteral(lit2.getDatatype().toString());
			return containsProperly(vec1.read(v1.stringValue()),LiteralUtils.toGeometry(vec2.read(v2.stringValue()).getGridGeometry().getEnvelope()));
		}else if(!type && type2) {
			RasterLiteral vec1=(RasterLiteral) LiteralRegistry.getLiteral(lit1.getDatatype().toString());
			VectorLiteral vec2=(VectorLiteral) LiteralRegistry.getLiteral(lit2.getDatatype().toString());
			return containsProperly(LiteralUtils.toGeometry(((GridCoverage)vec1.read(v1.stringValue())).getGridGeometry().getEnvelope()),vec2.read(v2.stringValue()));
		}else {
			RasterLiteral vec1=(RasterLiteral) LiteralRegistry.getLiteral(lit1.getDatatype().toString());
			RasterLiteral vec2=(RasterLiteral) LiteralRegistry.getLiteral(lit2.getDatatype().toString());
			return containsProperly(LiteralUtils.toGeometry(((GridCoverage)vec1.read(v1.stringValue())).getGridGeometry().getEnvelope()),LiteralUtils.toGeometry(vec2.read(v2.stringValue()).getGridGeometry().getEnvelope()));
		}
	}


public Boolean containsProperly(Geometry geom1,Geometry geom2) {
    if(!geom1.contains(geom2)) {
    	return false;
    }else {
    	Coordinate oldcoord=null;
    	for(Coordinate coord:geom1.getCoordinates()) {
    		if(oldcoord!=null) {
    			GeometryFactory fac=new GeometryFactory();
    			LineString ls=fac.createLineString(new Coordinate[] {oldcoord,coord});
    			if(ls.intersects(geom2)) {
    				return false;
    			}
    		}
    		oldcoord=coord;
    	}
    	return true;
    }
}
}
