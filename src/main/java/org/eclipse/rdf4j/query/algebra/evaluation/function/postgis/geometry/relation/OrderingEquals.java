package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.relation;

import org.apache.jena.sparql.expr.NodeValue;
import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricRelationBinaryFunction;

public class OrderingEquals extends GeometricRelationBinaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_orderingEquals.stringValue();
	}

	@Override
	protected boolean relation(Geometry geom1, Geometry geom2) {
		LiteralUtils.
		GeometryWrapper transGeom2 = geom2.transform(geom1.getSrsInfo());
		boolean equalsExact = geom1.equalsExact(geom2);
		return equalsExact;
	}

}
