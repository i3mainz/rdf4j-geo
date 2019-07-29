package main.java.de.hsmainz.rdf4jpostgis.geometry.exporter;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.kml.KMLWriter;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;

public class AsKML extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
        KMLWriter writer=new KMLWriter();
        String result=writer.write(geom);
        return result;
	}

}
