package main.java.de.hsmainz.rdf4jpostgis.geometry.transform;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.util.AffineTransformation;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierFunction;

public class Reflect extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_reflect.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Geometry geom2) {
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

}
