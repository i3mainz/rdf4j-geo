package main.java.de.hsmainz.rdf4jpostgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;

public class AsText extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
         return geom.toText();
	}

	@Override
	public String getURI() {
		return POSTGIS.ASTEXT.stringValue();
	}

}
