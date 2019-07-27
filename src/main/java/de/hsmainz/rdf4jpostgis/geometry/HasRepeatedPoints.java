package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.operation.valid.RepeatedPointTester;

public class HasRepeatedPoints extends GeometricAttributeFunction {

	@Override
	public boolean attribute(Geometry geom) {
		RepeatedPointTester tester=new RepeatedPointTester();
        return tester.hasRepeatedPoint(geom);
	}
}
