package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.gml2.GMLWriter;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;

/**
 * Returns a GML representation of a given geometry.
 */
public class AsGML extends GeometricStringExportFunction {

	@Override
	public String operation(Geometry geom) {
		GMLWriter writer=new GMLWriter();
        String result=writer.write(geom);
        return result.toString();
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGML.stringValue();
	}

}
