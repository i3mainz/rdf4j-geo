package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.editor;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierIntegerFunction;

public class SetSRID extends GeometricModifierIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setSRID.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Integer value) {
            Integer srid=value;
            geom.setSRID(srid.intValue());
            GeometryFactory fac=new GeometryFactory();
            return fac.createGeometry(geom);
    }

}
