package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class AddGeometry extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_addGeometry.stringValue();
	}

	@Override
	protected Geometry relation(Geometry g1, Geometry g2) {
		GeometryFactory fac=new GeometryFactory();
		List<Geometry> geometries=new LinkedList<Geometry>();
		for(int i=0;i<g1.getNumGeometries();i++) {
			geometries.add(g1.getGeometryN(i));
		}
		geometries.add(g2);
		return fac.createGeometryCollection(geometries.toArray(new Geometry[0]));
	}

}
