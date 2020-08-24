package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;
import org.opengis.util.FactoryException;

public class SridGetDatum extends GeometricStringExportFunction {

		@Override
		public String getURI() {
			return POSTGIS.SRIDGetDatum.stringValue();
		}
			@Override
			public String operation(Geometry geom) {
				return null;
				/*try {
					return CRS.getDatum(CRS.forCode("EPSG:"+geom.getSRID()).getCoordinateSystem().) .getName().toString();
				} catch (FactoryException e) {
					return null;
				} */
			}
		
}
