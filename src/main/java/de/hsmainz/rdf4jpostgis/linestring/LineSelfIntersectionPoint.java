package main.java.de.hsmainz.rdf4jpostgis.linestring;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class LineSelfIntersectionPoint extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_lineSelfIntersectionPoint.stringValue();
	}

	@Override
	protected Geometry operation(Geometry geom) {
        GeometryFactory fac=new GeometryFactory();    
		if(geom.isSimple()) {
            	return fac.createPoint();
            }else {
            	return LiteralUtils.createGeometry(geom.intersection(geom).getCoordinates(), "POINT", geom.getSRID());
            }
	}

}
