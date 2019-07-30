package main.java.de.hsmainz.rdf4jpostgis.geometry.editor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierIntegerFunction;

public class SetSRID extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setSRID.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
            Integer srid=value;
            geom.setSRID(srid.intValue());
            GeometryFactory fac=new GeometryFactory();
            return fac.createGeometry(geom);
    }

}
