package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.kml.KMLWriter;

public class AsKML extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
        KMLWriter writer=new KMLWriter();
        String result=writer.write(geom);
        return result;
	}

}
