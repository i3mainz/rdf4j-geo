package org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.linestring.transform;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.rdf4j.model.vocabulary.POSTGIS;
import org.eclipse.rdf4j.query.algebra.evaluation.function.postgis.geometry.base.GeometricModifierDoubleFunction;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.util.FactoryException;

public class SubdivideLines extends GeometricModifierDoubleFunction{

	@Override
	public String getURI() {
		return POSTGIS.st_subdividelines.stringValue();
	}

	@Override
	protected Geometry relation(Geometry geom, Double value) {
        double segmentLength = value;

        List<LineString> linestrings;
        try {
			linestrings = createSegments(geom, segmentLength);
	        GeometryFactory fac=new GeometryFactory();
	        return fac.createMultiLineString(linestrings.toArray(new LineString[0]));	
        } catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
 }
	
	public List<LineString> createSegments(Geometry track, double numberOfPoints) throws NoSuchAuthorityCodeException, FactoryException {
		GeometryFactory fac=new GeometryFactory();
        //GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING));
        List<LineString> segments = new ArrayList<>();
        int i=0;
        for(int j=0;j<track.getNumGeometries();j++) {
        	List<Coordinate> coords=new LinkedList<Coordinate>();
        	for(Coordinate coord:track.getGeometryN(j).getCoordinates()) {
        		if(i<numberOfPoints) {
        			coords.add(coord);
        		}else {
        			segments.add(fac.createLineString(coords.toArray(new Coordinate[0])));
        			coords=new LinkedList<Coordinate>();
        			i=0;
        		}
        	}
        }
        return segments;
    }

}
