package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.apache.sis.referencing.CRS;
import org.locationtech.jts.geom.Geometry;
import org.opengis.util.FactoryException;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class HasHorizontalCRS extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean attribute(Geometry geom) {
        try {
			return CRS.isHorizontalCRS(CRS.forCode("ESPG:"+geom.getSRID()));
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
	}

}
