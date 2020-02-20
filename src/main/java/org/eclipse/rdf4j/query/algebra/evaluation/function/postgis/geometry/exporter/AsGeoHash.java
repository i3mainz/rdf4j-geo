package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.exporter;

import org.locationtech.jts.geom.Geometry;
import org.apache.sis.referencing.gazetteer.GeohashReferenceSystem;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.util.literals.vector.GeoHashDatatype;


public class AsGeoHash extends GeometricStringExportFunction {

	GeohashReferenceSystem.Coder coder;
	
	@Override
	public String operation(Geometry geom) {
		return GeoHashDatatype.INSTANCE.unparse(geom);
	}

	@Override
	public String getURI() {
		return POSTGIS.ST_ASGEOHASH.stringValue();
	}

}
