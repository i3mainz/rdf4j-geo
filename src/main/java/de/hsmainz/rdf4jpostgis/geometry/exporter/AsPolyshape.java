package main.java.de.hsmainz.rdf4jpostgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;

public class AsPolyshape extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASPOLYSHAPE.stringValue();
	}

}
