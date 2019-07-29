package main.java.de.hsmainz.rdf4jpostgis.geometry;

import java.util.LinkedList;
import java.util.List;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateXYZM;
import org.locationtech.jts.geom.Geometry;

import de.hsmainz.cs.semgis.arqextension.util.LiteralUtils;
import io.github.galbiston.geosparql_jena.implementation.GeometryWrapper;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricUnaryFunction;

public class MultiplyZ extends GeometricUnaryFunction {

	@Override
	public String getURI() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Geometry operation(Geometry geom) {
		GeometryWrapper geometry = GeometryWrapper.extract(v1);
        Double factor=v2.getDouble();
        List<Coordinate> newcoords=new LinkedList<Coordinate>();
        for(Coordinate coord:geometry.getParsingGeometry().getCoordinates()) {
        	newcoords.add(new CoordinateXYZM(coord.x,coord.y,coord.z*factor,Double.NaN));
        }
        GeometryWrapper res=LiteralUtils.createGeometry(newcoords, geometry.getGeometryType(), geometry);
        return res.asNodeValue();
	}

}
