package main.java.de.hsmainz.rdf4jpostgis.geometry.exporter;

import org.apache.jena.sparql.expr.NodeValue;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.precision.GeometryPrecisionReducer;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricStringExportFunction;

public class AsTextRound extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		GeometryWrapper geometry = GeometryWrapper.extract(v1);
        Geometry geom = geometry.getXYGeometry();
        PrecisionModel pm = new PrecisionModel(Math.pow(10.0, v2.getDouble()));
        Geometry geom_mod=GeometryPrecisionReducer.reduce(geom, pm);
        GeometryWrapper wrapper=GeometryWrapperFactory.createGeometry(geom_mod, geometry.getGeometryDatatypeURI());
        //FlipCoordinates flip=new FlipCoordinates();
        //NodeValue wrapper2=flip.exec(wrapper.asNodeValue());
        //GeometryWrapper resultwrapper=GeometryWrapper.extract(wrapper2);
        return NodeValue.makeString(wrapper.getXYGeometry().toText());
	}

	@Override
	public String getURI() {
		return POSTGIS.ASTEXTROUND.stringValue();
	}

}
