package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsCollection extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean attribute(Geometry geom) {
        String type=geom.getGeometryType().toUpperCase();
        if("GEOMETRYCOLLECTION".equals(type) || "COMPOUNDCURVE".equals(type) || type.startsWith("MUTLI")) {
            return true;
        }
        return false;
    
	}

}
