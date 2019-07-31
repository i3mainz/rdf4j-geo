package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;


import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;


public class AsLatLonText  extends GeometricStringExportFunction{

	@Override
	public String operation(Geometry geom) {
		if(geom.getGeometryType().equalsIgnoreCase("POINT")) {
			return convertDecimalToLatLonText(geom.getCoordinate().x,false)+" "+convertDecimalToLatLonText(geom.getCoordinate().getY(),true);	
		}else {
			return convertDecimalToLatLonText(geom.getCentroid().getCoordinate().x,false)+" "+convertDecimalToLatLonText(geom.getCentroid().getCoordinate().getY(),true);

		}
	}
	
	public String convertDecimalToLatLonText(Double D, Boolean lng){
	    String dir;
		if(D<0) {
			if(lng) {
				dir="W";
			}else {
				dir="S";
			}
		}else {
			if(lng) {
				dir="E";
			}else {
				dir="N";
			}
		}
		Double deg=D<0?-D:D;
		Double min=D%1*60;
		Double sec=(D*60%1*6000)/100;
		return deg+"°"+min+"'"+sec+"\""+dir;
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASLATLONTEXT.stringValue();
	}

}
