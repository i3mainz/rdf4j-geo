package main.java.de.hsmainz.rdf4jpostgis.geometry;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;

import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class MinimumRectangle extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_minimumRectangle.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
		org.locationtech.jts.algorithm.MinimumDiameter mindiam=new org.locationtech.jts.algorithm.MinimumDiameter(geom);
        return mindiam.getMinimumRectangle();
	}

}
