package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricStringExportFunction;
import org.locationtech.jts.geom.Geometry;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.util.FactoryException;

public class SridGetAxis2Name extends GeometricStringExportFunction {

	@Override
	public String getURI() {
		return POSTGIS.SRIDGetAxis2Name.stringValue();
	}

	@Override
	public String operation(Geometry geom) {
		CoordinateReferenceSystem crs;
		try {
			crs = CRS.forCode("EPSG:"+geom.getSRID());
			return crs.getCoordinateSystem().getAxis(1).getName().toString();
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
