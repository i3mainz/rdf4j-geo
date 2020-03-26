package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.polygon.attribute;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricBinaryAttributeFunction;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geomgraph.GeometryGraph;
import org.locationtech.jts.operation.valid.ConnectedInteriorTester;

public class HasConnectedInterior extends GeometricBinaryAttributeFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_hasConnectedInterior.stringValue();
	}

	@Override
	public boolean attribute(Geometry geom) {
		ConnectedInteriorTester tester=new ConnectedInteriorTester(new GeometryGraph(0,geom));
		return tester.isInteriorsConnected();
	}

}
