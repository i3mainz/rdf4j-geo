package main.java.de.hsmainz.rdf4jpostgis.geometry.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;

import de.hsmainz.rdf4jpostgis.util.LiteralUtils;
import main.java.de.hsmainz.rdf4jpostgis.geometry.base.GeometricModifierDoubleFunction;

public class RemoveRepeatedPoints extends GeometricModifierDoubleFunction {

	@Override
	public String getURI() {
		return POSTGIS.st_removeRepeatedPoints.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double value) {
        if(geom.getGeometryType().equalsIgnoreCase("Point")) {
        	return geom;
        }
        Double tolerance=value;
        int i=0,j=0;
        boolean repeated=false;
        List<Coordinate> result=new LinkedList<Coordinate>();
        for(Coordinate coord:geom.getCoordinates()) {
        	j=0;
        	repeated=false;
        	for(Coordinate coord2:geom.getCoordinates()) {
        		if(i!=j && coord.equals2D(coord2, tolerance)) {
        			repeated=true;
        		}
        		j++;
        	}
    		if(!repeated) {
    			result.add(coord);
    		}
        	i++;
        }
    	return LiteralUtils.createGeometry(result, geom.getGeometryType(), geom.getSRID());
	}

}
