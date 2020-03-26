package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.geotoolkit.referencing.CRS;
import org.locationtech.jts.geom.Geometry;
import org.opengis.util.FactoryException;

public class SridIsProjected extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.SRIDIsProjected.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		try {
			return CRS.getProjectedCRS(CRS.decode("EPSG:"+geom.getSRID()))!=null;
		} catch (FactoryException e) {
			return false;
		} 
	}

}
