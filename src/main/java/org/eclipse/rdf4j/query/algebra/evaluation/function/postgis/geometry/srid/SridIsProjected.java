package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Geometry;
import org.opengis.util.FactoryException;

public class SridIsProjected extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.SRIDIsProjected.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		return false;
		/*try {
			return CRS.getProjectedCRS(CRS.forCode("EPSG:"+geom.getSRID()).)!=null;
		} catch (FactoryException e) {
			return false;
		} */
	}

}
