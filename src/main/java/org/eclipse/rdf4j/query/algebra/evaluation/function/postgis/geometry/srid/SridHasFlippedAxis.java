package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Geometry;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.util.FactoryException;

public class SridHasFlippedAxis extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.SRIDHasFlippedAxis.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		CoordinateReferenceSystem crs;
		try {
			crs = CRS.forCode("EPSG:"+geom.getSRID());
			if("Y".equals(crs.getCoordinateSystem().getAxis(0).getName().toString()) && "X".equals(crs.getCoordinateSystem().getAxis(1).getName().toString())){
				return true;
			}
			return false;
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
