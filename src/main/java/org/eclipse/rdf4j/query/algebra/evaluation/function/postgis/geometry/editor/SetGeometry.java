package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierGeometryIntegerFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class SetGeometry extends GeometricModifierGeometryIntegerFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setGeometry.stringValue();
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry geom2, Integer value) {
		GeometryFactory fac=new GeometryFactory();
		List<Geometry> geometries=new LinkedList<Geometry>();
		for(int i=0;i<g1.getNumGeometries();i++) {
			if(value==i) {
				geometries.add(geom2);
			}else {
				geometries.add(g1.getGeometryN(i));
			}
		}
		return fac.createGeometryCollection(geometries.toArray(new Geometry[0]));
	}

}
