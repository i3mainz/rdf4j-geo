package main.java.de.hsmainz.rdf4jpostgis.geometry.attribute;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.valid.RepeatedPointTester;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricBinaryAttributeFunction;

public class HasRepeatedPoints extends GeometricBinaryAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		RepeatedPointTester tester=new RepeatedPointTester();
        return tester.hasRepeatedPoint(geom);
	}
}
