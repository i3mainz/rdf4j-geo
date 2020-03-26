package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.geotoolkit.referencing.CRS;
import org.locationtech.jts.geom.Geometry;
import org.opengis.util.FactoryException;

public class SridGetDatum extends GeometricStringExportFunction {

		@Override
		public String getURI() {
			return POSTGIS.SRIDGetDatum.stringValue();
		}
			@Override
			public String operation(Geometry geom) {
				try {
					return CRS.getDatum(CRS.decode("EPSG:"+geom.getSRID())).getName().toString();
				} catch (FactoryException e) {
					return null;
				} 
			}
		
}
