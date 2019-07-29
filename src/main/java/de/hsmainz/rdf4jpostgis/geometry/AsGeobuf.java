package main.java.de.hsmainz.rdf4jpostgis.geometry;

import java.io.ByteArrayOutputStream;

import org.locationtech.jts.geom.Geometry;

import com.conveyal.data.geobuf.GeobufEncoder;


public class AsGeobuf extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
         ByteArrayOutputStream output=new ByteArrayOutputStream();
         GeobufEncoder enc=new GeobufEncoder(output,geom.getPrecisionModel().getMaximumSignificantDigits());
         Geometry buf=enc.geomToGeobuf(geom);
         return buf.toString();
	}

}
