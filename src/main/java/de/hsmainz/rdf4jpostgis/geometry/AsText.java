package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;

public class AsText extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
         return geom.toText();
	}

}
