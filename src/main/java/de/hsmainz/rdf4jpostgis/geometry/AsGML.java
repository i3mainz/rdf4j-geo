package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.gml2.GMLWriter;

public class AsGML extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		GMLWriter writer=new GMLWriter();
        String result=writer.write(geom);
        return result.toString();
	}

}
