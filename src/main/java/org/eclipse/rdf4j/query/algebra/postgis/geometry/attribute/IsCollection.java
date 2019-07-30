package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class IsCollection extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_isCollection.stringValue();
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
