package main.java.de.hsmainz.rdf4jpostgis.geometry.exporter;

import java.io.ByteArrayOutputStream;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import com.conveyal.data.geobuf.GeobufEncoder;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;


public class AsGeobuf extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
         ByteArrayOutputStream output=new ByteArrayOutputStream();
         GeobufEncoder enc=new GeobufEncoder(output,geom.getPrecisionModel().getMaximumSignificantDigits());
         Geometry buf=enc.geomToGeobuf(geom);
         return buf.toString();
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGEOBUF.stringValue();
	}

}
