package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.srid;

import org.apache.sis.referencing.CRS;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Geometry;
import org.opengis.util.FactoryException;

public class SridIsVertical extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.SRIDIsVertical.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		return false;
		/*try {
			return CRS.getVerticalCRS(CRS.decode("EPSG:"+geom.getSRID()))!=null;
>>>>>>> 237275ccb45fa5d7012a3c2bceba8868ccdcceeb
		} catch (FactoryException e) {
			return false;
		}*/ 
	}

}
