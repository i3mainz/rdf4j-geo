package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;
import org.opengis.util.FactoryException;

public class GeomCRSToWKT extends GeometricStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.GeomCRSToWKT.stringValue();
	}

	@Override
	public String operation(Geometry geom) {
		Integer srid=Integer.valueOf(geom.getSRID());
		try {
			return CRS.forCode("EPSG:"+srid).toWKT();
		} catch (UnsupportedOperationException | FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
