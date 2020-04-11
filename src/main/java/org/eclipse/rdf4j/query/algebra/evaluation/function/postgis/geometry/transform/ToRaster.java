package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.transform;

import org.apache.sis.coverage.grid.GridCoverage;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricExportToRasterFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.util.AffineTransformation;

import gov.noaa.ncdc.geotools.VectorToRaster;

public class ToRaster extends GeometricExportToRasterFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_toRaster.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, String attributeName) {
	        if(geom2.getGeometryType().equalsIgnoreCase("LineString") || geom2.getGeometryType().equalsIgnoreCase("Point")) {
	        	AffineTransformation trans = new AffineTransformation();
	        	if(geom2.getGeometryType().equalsIgnoreCase("Point")) {
	        		trans.setToReflection(geom2.getCoordinates()[0].x, geom2.getCoordinates()[0].y);		        		
	        	}else {
	        		trans.setToReflection(geom2.getCoordinates()[0].x, geom2.getCoordinates()[0].y, geom2.getCoordinates()[geom2.getCoordinates().length-1].x, geom2.getCoordinates()[geom2.getCoordinates().length-1].y);	
	        	}
	        	return trans.transform(geom);
	        }
	        return null;
	}

	@Override
	public GridCoverage operation(Geometry geom) {
		VectorToRaster vectorast=new VectorToRaster();
		vectorast.
		// TODO Auto-generated method stub
		return null;
	}

}
