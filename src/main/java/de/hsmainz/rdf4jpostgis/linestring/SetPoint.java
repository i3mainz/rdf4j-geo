package main.java.de.hsmainz.rdf4jpostgis.linestring;

import java.math.BigInteger;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapperFactory;
import io.github.galbiston.geosparql_jena.implementation.datatype.WKTDatatype;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierFunction;

public class SetPoint extends GeometricModifierFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_setPoint.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom1, Geometry geom2) {
        GeometryWrapper transGeom2 = geom2.transform(geom1.getSRID());
        BigInteger zerobasedposition=arg1.getInteger();
        if (geom1 instanceof LineString && transGeom2 instanceof Point) {
            Coordinate[] coords=geom1.getCoordinates();
            Coordinate[] newcoords=coords;
            newcoords[zerobasedposition.intValue()]=geom2.getCoordinate();
            return LiteralUtils.createGeometry(newcoords, geom1.getGeometryType(), geom1.getSRID());
        }
	}

}
